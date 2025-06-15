package com.example.timeatbleschedulerapp.services

import android.util.Log
import com.example.timeatbleschedulerapp.data.repository.FCMRepository
import com.example.timeatbleschedulerapp.data.repository.NotificationRepository
import javax.inject.Inject
import javax.inject.Singleton

private const val TAG = "NotificationManager"

@Singleton
class NotificationManager @Inject constructor(
    private val notificationRepository: NotificationRepository,
    private val fcmRepository: FCMRepository,
    private val firebaseAdminService: FirebaseAdminService
) {

    suspend fun sendCompleteNotification(
        title: String,
        message: String,
        senderId: String,
        senderName: String,
        recipientIds: List<String>
    ): Result<String> {
        return try {
            Log.d(TAG, "🚀 Starting complete notification process")
            Log.d(TAG, "📧 Title: $title")
            Log.d(TAG, "👥 Recipients: ${recipientIds.size}")
            Log.d(TAG, "👤 Sender: $senderName ($senderId)")

            // Step 1: Validate inputs
            if (title.isBlank() || message.isBlank()) {
                return Result.failure(Exception("Title and message cannot be empty"))
            }

            if (recipientIds.isEmpty()) {
                return Result.failure(Exception("No recipients specified"))
            }

            // Step 2: Store notification in Firestore
            Log.d(TAG, "💾 Step 1: Storing notification in Firestore...")
            val storeResult = notificationRepository.sendNotification(
                title, message, senderId, senderName, recipientIds
            )

            if (storeResult.isFailure) {
                Log.e(TAG, "❌ Failed to store notification: ${storeResult.exceptionOrNull()?.message}")
                return Result.failure(storeResult.exceptionOrNull() ?: Exception("Failed to store notification"))
            }

            val notificationId = storeResult.getOrThrow()
            Log.d(TAG, "✅ Notification stored with ID: $notificationId")

            // Step 3: Get FCM tokens for recipients
            Log.d(TAG, "🔍 Step 2: Getting FCM tokens for recipients...")
            val tokensResult = fcmRepository.getFCMTokensForUsers(recipientIds)
            if (tokensResult.isFailure) {
                Log.w(TAG, "⚠️ Failed to get FCM tokens: ${tokensResult.exceptionOrNull()?.message}")
                Log.w(TAG, "📝 Notification stored but no push notifications will be sent")
                return storeResult // Return success for storage even if FCM fails
            }

            val tokens = tokensResult.getOrThrow()
            Log.d(TAG, "📱 Retrieved ${tokens.size} valid FCM tokens")

            if (tokens.isEmpty()) {
                Log.w(TAG, "⚠️ No valid FCM tokens found for recipients")
                Log.w(TAG, "💡 Users may need to log in again to refresh their tokens")
                return storeResult // Still success since notification was stored
            }

            // Step 4: Send FCM push notifications using Firebase Admin SDK
            Log.d(TAG, "📤 Step 3: Sending FCM push notifications via Firebase Admin API...")
            val fcmResult = firebaseAdminService.sendNotificationToTokens(
                tokens = tokens,
                title = title,
                body = message,
                data = mapOf(
                    "notificationId" to notificationId,
                    "senderId" to senderId,
                    "senderName" to senderName,
                    "type" to "timetable_notification",
                    "timestamp" to System.currentTimeMillis().toString()
                )
            )

            if (fcmResult.isSuccess) {
                val successCount = fcmResult.getOrThrow()
                Log.d(TAG, "🎉 FCM notifications sent successfully to $successCount devices")
                Log.d(TAG, "✅ Complete notification process finished successfully")
            } else {
                Log.e(TAG, "❌ FCM sending failed: ${fcmResult.exceptionOrNull()?.message}")
                Log.w(TAG, "📝 Notification was stored but push delivery failed")
            }

            // Return success if notification was stored, regardless of FCM result
            storeResult

        } catch (e: Exception) {
            Log.e(TAG, "💥 Error in sendCompleteNotification", e)
            Result.failure(e)
        }
    }

    suspend fun sendTestNotification(recipientId: String): Result<String> {
        return try {
            Log.d(TAG, "🧪 Sending test notification to user: $recipientId")

            sendCompleteNotification(
                title = "🧪 Test Notification",
                message = "This is a test notification using Firebase Admin SDK! If you see this, your notification system is working perfectly! 🎉✨",
                senderId = "system",
                senderName = "System Test",
                recipientIds = listOf(recipientId)
            )
        } catch (e: Exception) {
            Log.e(TAG, "💥 Error sending test notification", e)
            Result.failure(e)
        }
    }
}
