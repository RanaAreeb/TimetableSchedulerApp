package com.example.timeatbleschedulerapp.utils

import android.util.Log
import com.example.timeatbleschedulerapp.data.repository.AuthRepository
import com.example.timeatbleschedulerapp.services.FirebaseAdminService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NotificationTestHelper @Inject constructor(
    private val firebaseAdminService: FirebaseAdminService,
    private val authRepository: AuthRepository
) {
    private val TAG = "NotificationTestHelper"

    suspend fun testFirebaseAdminSetup(): String {
        return try {
            Log.d(TAG, "🧪 Testing Firebase Admin SDK setup...")

            val accessToken = firebaseAdminService.getAccessToken()

            val result = buildString {
                appendLine("=== Firebase Admin SDK Test ===")
                appendLine("✅ Service account file loaded: ${accessToken != null}")
                appendLine("🔑 Access token obtained: ${if (accessToken != null) "YES" else "NO"}")
                if (accessToken != null) {
                    appendLine("📝 Token preview: ${accessToken.take(50)}...")
                }
                appendLine("🏗️ Project ID: time-c74a6")
                appendLine("📧 Service account: firebase-adminsdk-fbsvc@time-c74a6.iam.gserviceaccount.com")
            }

            Log.d(TAG, result)
            result
        } catch (e: Exception) {
            val error = "❌ Firebase Admin SDK Test Error: ${e.message}"
            Log.e(TAG, error, e)
            error
        }
    }

    suspend fun sendTestNotificationDirect(): String {
        return try {
            val currentUser = authRepository.getCurrentUser()
            if (currentUser == null) {
                return "❌ User not authenticated"
            }

            if (currentUser.fcmToken.isEmpty()) {
                return "❌ No FCM token found for current user"
            }

            Log.d(TAG, "🚀 Sending direct test notification...")

            val result = firebaseAdminService.sendNotificationToTokens(
                tokens = listOf(currentUser.fcmToken),
                title = "🧪 Direct Test",
                body = "This is a direct test using Firebase Admin SDK!",
                data = mapOf(
                    "test" to "true",
                    "timestamp" to System.currentTimeMillis().toString()
                )
            )

            if (result.isSuccess) {
                "✅ Direct test notification sent successfully!"
            } else {
                "❌ Direct test failed: ${result.exceptionOrNull()?.message}"
            }
        } catch (e: Exception) {
            "❌ Direct test error: ${e.message}"
        }
    }
}
