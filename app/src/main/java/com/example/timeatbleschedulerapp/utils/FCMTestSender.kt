package com.example.timeatbleschedulerapp.utils

import android.util.Log
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.coroutines.tasks.await

object FCMTestSender {
    private const val TAG = "FCMTestSender"

    suspend fun sendTestNotificationToCurrentDevice(): Boolean {
        return try {
            val token = FirebaseMessaging.getInstance().token.await()
            Log.d(TAG, "Current device token: $token")

            // You can use this token to send a test notification from Firebase Console
            // Go to Firebase Console -> Cloud Messaging -> Send your first message
            // Use this token in the "FCM registration token" field

            Log.d(TAG, "Copy this token to Firebase Console for testing: $token")
            true
        } catch (e: Exception) {
            Log.e(TAG, "Error getting token for test", e)
            false
        }
    }
}
