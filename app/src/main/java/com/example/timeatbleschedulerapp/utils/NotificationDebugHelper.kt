package com.example.timeatbleschedulerapp.utils

import android.util.Log
import com.example.timeatbleschedulerapp.data.repository.AuthRepository
import com.example.timeatbleschedulerapp.data.repository.NotificationRepository
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NotificationDebugHelper @Inject constructor(
    private val authRepository: AuthRepository,
    private val notificationRepository: NotificationRepository,
    private val firestore: FirebaseFirestore
) {
    private val TAG = "NotificationDebug"

    suspend fun debugNotificationFlow() {
        try {
            val currentUser = authRepository.getCurrentUser()
            Log.d(TAG, "=== NOTIFICATION DEBUG START ===")
            Log.d(TAG, "Current user: ${currentUser?.email} (ID: ${currentUser?.id})")
            Log.d(TAG, "Current user FCM token: ${currentUser?.fcmToken}")

            // Check if user exists in Firestore
            val userId = authRepository.getCurrentUserId()
            if (userId != null) {
                val userDoc = firestore.collection("users").document(userId).get().await()
                Log.d(TAG, "User document exists: ${userDoc.exists()}")
                if (userDoc.exists()) {
                    val userData = userDoc.data
                    Log.d(TAG, "User data: $userData")
                }
            }

            // Check notifications for current user
            if (userId != null) {
                val notificationsResult = notificationRepository.getNotificationsForUser(userId)
                if (notificationsResult.isSuccess) {
                    val notifications = notificationsResult.getOrThrow()
                    Log.d(TAG, "Found ${notifications.size} notifications for user")
                    notifications.forEach { notification ->
                        Log.d(TAG, "Notification: ${notification.title} - Recipients: ${notification.recipientIds}")
                    }
                } else {
                    Log.e(TAG, "Failed to get notifications: ${notificationsResult.exceptionOrNull()?.message}")
                }
            }

            // Check all notifications in Firestore
            val allNotifications = firestore.collection("notifications").get().await()
            Log.d(TAG, "Total notifications in Firestore: ${allNotifications.size()}")
            allNotifications.documents.forEach { doc ->
                val data = doc.data
                Log.d(TAG, "Notification doc: ${doc.id} - Data: $data")
            }

            Log.d(TAG, "=== NOTIFICATION DEBUG END ===")
        } catch (e: Exception) {
            Log.e(TAG, "Error in debug flow", e)
        }
    }
}
