package com.example.timeatbleschedulerapp.data.repository

import android.util.Log
import com.example.timeatbleschedulerapp.data.models.Notification
import com.example.timeatbleschedulerapp.data.models.User
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

private const val TAG = "NotificationRepository"

@Singleton
class NotificationRepository @Inject constructor(
    private val firestore: FirebaseFirestore
) {

    suspend fun sendNotification(
        title: String,
        message: String,
        senderId: String,
        senderName: String,
        recipientIds: List<String>
    ): Result<String> {
        return try {
            val notificationId = firestore.collection("notifications").document().id
            val notification = Notification(
                id = notificationId,
                title = title,
                message = message,
                senderId = senderId,
                senderName = senderName,
                recipientIds = recipientIds,
                timestamp = System.currentTimeMillis(),
                isRead = false
            )

            // Store notification in Firestore
            firestore.collection("notifications")
                .document(notificationId)
                .set(notification)
                .await()

            Log.d(TAG, "Notification stored successfully: $notificationId")
            Log.d(TAG, "Recipients: $recipientIds")
            Log.d(TAG, "Notification data: $notification")

            Result.success(notificationId)
        } catch (e: Exception) {
            Log.e(TAG, "Error storing notification", e)
            Result.failure(e)
        }
    }

    suspend fun getNotificationsForUser(userId: String): Result<List<Notification>> {
        return try {
            Log.d(TAG, "Getting notifications for user: $userId")

            // First, let's try a simple query to see all notifications
            val allNotificationsQuery = firestore.collection("notifications")
                .orderBy("timestamp", Query.Direction.DESCENDING)
                .get()
                .await()

            Log.d(TAG, "Total notifications in database: ${allNotificationsQuery.size()}")

            // Filter notifications that contain the user ID in recipientIds
            val userNotifications = mutableListOf<Notification>()

            allNotificationsQuery.documents.forEach { doc ->
                try {
                    val notification = doc.toObject(Notification::class.java)
                    if (notification != null) {
                        Log.d(TAG, "Checking notification ${notification.id}: recipients = ${notification.recipientIds}")
                        if (notification.recipientIds.contains(userId)) {
                            userNotifications.add(notification)
                            Log.d(TAG, "Added notification ${notification.title} for user $userId")
                        }
                    }
                } catch (e: Exception) {
                    Log.e(TAG, "Error parsing notification document ${doc.id}", e)
                }
            }

            Log.d(TAG, "Found ${userNotifications.size} notifications for user $userId")
            Result.success(userNotifications)

        } catch (e: Exception) {
            Log.e(TAG, "Error getting notifications for user $userId", e)
            Result.failure(e)
        }
    }

    suspend fun markNotificationAsRead(notificationId: String): Result<Unit> {
        return try {
            firestore.collection("notifications")
                .document(notificationId)
                .update("isRead", true)
                .await()

            Log.d(TAG, "Notification marked as read: $notificationId")
            Result.success(Unit)
        } catch (e: Exception) {
            Log.e(TAG, "Error marking notification as read", e)
            Result.failure(e)
        }
    }

    suspend fun getAllStudents(): Result<List<User>> {
        return try {
            val querySnapshot = firestore.collection("users")
                .whereEqualTo("role", "STUDENT")
                .get()
                .await()

            val students = querySnapshot.documents.mapNotNull { doc ->
                try {
                    doc.toObject(User::class.java)
                } catch (e: Exception) {
                    Log.e(TAG, "Error parsing user document ${doc.id}", e)
                    null
                }
            }

            Log.d(TAG, "Retrieved ${students.size} students")
            Result.success(students)
        } catch (e: Exception) {
            Log.e(TAG, "Error getting students", e)
            Result.failure(e)
        }
    }

    suspend fun getStudentsByBatch(batchId: String): Result<List<User>> {
        return try {
            val querySnapshot = firestore.collection("users")
                .whereEqualTo("role", "STUDENT")
                .whereEqualTo("batchId", batchId)
                .get()
                .await()

            val students = querySnapshot.documents.mapNotNull { doc ->
                try {
                    doc.toObject(User::class.java)
                } catch (e: Exception) {
                    Log.e(TAG, "Error parsing user document ${doc.id}", e)
                    null
                }
            }

            Log.d(TAG, "Retrieved ${students.size} students for batch $batchId")
            Result.success(students)
        } catch (e: Exception) {
            Log.e(TAG, "Error getting students for batch $batchId", e)
            Result.failure(e)
        }
    }
}
