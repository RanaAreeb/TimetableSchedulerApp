package com.example.timeatbleschedulerapp.data.repository

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

private const val TAG = "FCMRepository"

@Singleton
class FCMRepository @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val auth: FirebaseAuth
) {

    suspend fun updateFCMToken(): Result<String> {
        return try {
            val token = FirebaseMessaging.getInstance().token.await()
            val userId = auth.currentUser?.uid

            if (userId != null && token.isNotEmpty()) {
                // Store token in user document
                firestore.collection("users")
                    .document(userId)
                    .update("fcmToken", token)
                    .await()

                Log.d(TAG, "FCM token updated for user $userId: $token")
                Result.success(token)
            } else {
                Result.failure(Exception("User not authenticated or token empty"))
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error updating FCM token", e)
            Result.failure(e)
        }
    }

    suspend fun getFCMTokensForUsers(userIds: List<String>): Result<List<String>> {
        return try {
            val tokens = mutableListOf<String>()

            for (userId in userIds) {
                try {
                    val userDoc = firestore.collection("users")
                        .document(userId)
                        .get()
                        .await()

                    val token = userDoc.getString("fcmToken")
                    if (!token.isNullOrEmpty()) {
                        tokens.add(token)
                    }
                } catch (e: Exception) {
                    Log.w(TAG, "Error getting token for user $userId", e)
                }
            }

            Log.d(TAG, "Retrieved ${tokens.size} FCM tokens")
            Result.success(tokens)
        } catch (e: Exception) {
            Log.e(TAG, "Error getting FCM tokens", e)
            Result.failure(e)
        }
    }
}
