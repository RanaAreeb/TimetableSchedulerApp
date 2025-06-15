package com.example.timeatbleschedulerapp.utils

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.coroutines.tasks.await

object FCMTestHelper {
    private const val TAG = "FCMTestHelper"

    suspend fun testFCMSetup(): String {
        return try {
            val auth = FirebaseAuth.getInstance()
            val firestore = FirebaseFirestore.getInstance()
            val messaging = FirebaseMessaging.getInstance()

            val currentUser = auth.currentUser
            if (currentUser == null) {
                return "User not authenticated"
            }

            // Get FCM token
            val token = messaging.token.await()
            Log.d(TAG, "Current FCM token: $token")

            // Check if token is saved in user document
            val userDoc = firestore.collection("users").document(currentUser.uid).get().await()
            val savedToken = userDoc.getString("fcmToken")

            val result = buildString {
                appendLine("=== FCM Test Results ===")
                appendLine("User ID: ${currentUser.uid}")
                appendLine("Current FCM Token: $token")
                appendLine("Saved FCM Token: $savedToken")
                appendLine("Tokens match: ${token == savedToken}")
                appendLine("User document exists: ${userDoc.exists()}")
            }

            Log.d(TAG, result)
            result
        } catch (e: Exception) {
            val error = "FCM Test Error: ${e.message}"
            Log.e(TAG, error, e)
            error
        }
    }
}
