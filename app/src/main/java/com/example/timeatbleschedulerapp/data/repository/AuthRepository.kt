package com.example.timeatbleschedulerapp.data.repository

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import com.example.timeatbleschedulerapp.data.models.User
import com.example.timeatbleschedulerapp.data.models.UserRole
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.messaging.FirebaseMessaging
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
import javax.inject.Inject
import javax.inject.Singleton

private const val TAG = "AuthRepository"
private const val OPERATION_TIMEOUT = 15000L
private const val MAX_RETRIES = 2

@Singleton
class AuthRepository @Inject constructor(
    private val auth: FirebaseAuth,
    private val firestore: FirebaseFirestore,
    @ApplicationContext private val context: Context
) {

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork ?: return false
        val networkCapabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
        return networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }

    suspend fun signUp(email: String, password: String, name: String, role: UserRole): Result<User> {
        return withContext(Dispatchers.IO) {
            try {
                if (!isNetworkAvailable()) {
                    Log.e(TAG, "No network connection available")
                    return@withContext Result.failure(Exception("No internet connection. Please check your network and try again."))
                }

                Log.d(TAG, "Starting sign up process for $email")

                var lastException: Exception? = null
                repeat(MAX_RETRIES) { attempt ->
                    try {
                        Log.d(TAG, "Sign up attempt ${attempt + 1} for $email")

                        val authResult = withTimeout(OPERATION_TIMEOUT) {
                            auth.createUserWithEmailAndPassword(email, password).await()
                        }

                        val userId = authResult.user?.uid ?: throw Exception("User creation failed - no user ID returned")
                        Log.d(TAG, "User created with ID: $userId, now creating user document")

                        // Get FCM token
                        val token = try {
                            FirebaseMessaging.getInstance().token.await()
                        } catch (e: Exception) {
                            Log.w(TAG, "Failed to get FCM token during signup", e)
                            ""
                        }

                        val user = User(
                            id = userId,
                            email = email,
                            name = name,
                            role = role,
                            batchId = "", // Will be set later by coordinator
                            profileImageUrl = "",
                            fcmToken = token
                        )

                        try {
                            withTimeout(OPERATION_TIMEOUT) {
                                firestore.collection("users").document(userId).set(user).await()
                            }
                            Log.d(TAG, "User document created successfully for $userId")
                            return@withContext Result.success(user)
                        } catch (e: Exception) {
                            Log.e(TAG, "Error creating user document: ${e.message}")
                            try {
                                auth.currentUser?.delete()?.await()
                                Log.d(TAG, "Deleted auth user after Firestore error")
                            } catch (deleteError: Exception) {
                                Log.e(TAG, "Failed to delete auth user after Firestore error: ${deleteError.message}")
                            }
                            throw Exception("Failed to create user profile: ${e.message}")
                        }

                    } catch (e: FirebaseAuthWeakPasswordException) {
                        Log.e(TAG, "Weak password: ${e.message}")
                        return@withContext Result.failure(Exception("Password is too weak. Please use at least 6 characters."))
                    } catch (e: FirebaseAuthInvalidCredentialsException) {
                        Log.e(TAG, "Invalid email: ${e.message}")
                        return@withContext Result.failure(Exception("Invalid email format."))
                    } catch (e: FirebaseAuthUserCollisionException) {
                        Log.e(TAG, "User already exists: ${e.message}")
                        return@withContext Result.failure(Exception("An account with this email already exists."))
                    } catch (e: FirebaseAuthException) {
                        Log.e(TAG, "Firebase auth error: ${e.message}")
                        lastException = Exception("Authentication error: ${e.message}")
                    } catch (e: FirebaseNetworkException) {
                        Log.e(TAG, "Network error: ${e.message}")
                        lastException = Exception("Network error. Please check your connection.")
                    } catch (e: Exception) {
                        Log.e(TAG, "Error on attempt ${attempt + 1}: ${e.message}")
                        lastException = e
                    }

                    if (attempt < MAX_RETRIES - 1) {
                        delay(2000)
                    }
                }

                Result.failure(lastException ?: Exception("Sign up failed after $MAX_RETRIES attempts"))

            } catch (e: Exception) {
                Log.e(TAG, "Error in signUp: ${e.message}", e)
                Result.failure(e)
            }
        }
    }

    suspend fun signIn(email: String, password: String): Result<User> {
        return withContext(Dispatchers.IO) {
            try {
                if (!isNetworkAvailable()) {
                    Log.e(TAG, "No network connection available")
                    return@withContext Result.failure(Exception("No internet connection. Please check your network and try again."))
                }

                Log.d(TAG, "Starting sign in process for $email")

                val authResult = withTimeout(OPERATION_TIMEOUT) {
                    try {
                        auth.signInWithEmailAndPassword(email, password).await()
                    } catch (e: FirebaseAuthInvalidCredentialsException) {
                        Log.e(TAG, "Invalid credentials: ${e.message}")
                        throw Exception("Invalid email or password.")
                    } catch (e: FirebaseAuthException) {
                        Log.e(TAG, "Firebase auth error: ${e.message}")
                        throw Exception("Authentication error: ${e.message}")
                    } catch (e: FirebaseNetworkException) {
                        Log.e(TAG, "Network error: ${e.message}")
                        throw Exception("Network error. Please check your connection.")
                    } catch (e: Exception) {
                        Log.e(TAG, "Unknown error during sign in: ${e.message}")
                        throw e
                    }
                }

                val userId = authResult.user?.uid ?: throw Exception("Sign in failed - no user ID returned")

                try {
                    val userDoc = withTimeout(OPERATION_TIMEOUT) {
                        firestore.collection("users").document(userId).get().await()
                    }

                    if (!userDoc.exists()) {
                        Log.e(TAG, "User document does not exist for $userId")
                        throw Exception("User profile not found. Please contact support.")
                    }

                    val user = userDoc.toObject(User::class.java)
                        ?: throw Exception("Failed to parse user data")

                    // Update FCM token on sign in
                    try {
                        val newToken = FirebaseMessaging.getInstance().token.await()
                        if (newToken.isNotEmpty() && newToken != user.fcmToken) {
                            firestore.collection("users")
                                .document(userId)
                                .update("fcmToken", newToken)
                                .await()
                            Log.d(TAG, "FCM token updated on sign in")
                        }
                    } catch (e: Exception) {
                        Log.w(TAG, "Failed to update FCM token on sign in", e)
                    }

                    Log.d(TAG, "User signed in successfully: ${user.name}")
                    Result.success(user)
                } catch (e: Exception) {
                    Log.e(TAG, "Error fetching user data after sign in: ${e.message}")
                    Result.failure(e)
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error in signIn: ${e.message}", e)
                Result.failure(e)
            }
        }
    }

    fun signOut() {
        auth.signOut()
        Log.d(TAG, "User signed out")
    }

    fun getCurrentUserId(): String? = auth.currentUser?.uid

    suspend fun getCurrentUser(): User? {
        val userId = getCurrentUserId() ?: return null
        return try {
            val userDoc = firestore.collection("users").document(userId).get().await()
            userDoc.toObject(User::class.java)
        } catch (e: Exception) {
            Log.e(TAG, "Error getting current user: ${e.message}")
            null
        }
    }
}
