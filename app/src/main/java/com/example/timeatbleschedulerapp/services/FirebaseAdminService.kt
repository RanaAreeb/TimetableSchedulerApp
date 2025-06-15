package com.example.timeatbleschedulerapp.services

import android.content.Context
import android.util.Log
import com.google.auth.oauth2.GoogleCredentials
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL
import javax.inject.Inject
import javax.inject.Singleton

private const val TAG = "FirebaseAdminService"

@Singleton
class FirebaseAdminService @Inject constructor(
    @ApplicationContext private val context: Context
) {

    private var accessToken: String? = null
    private var tokenExpiry: Long = 0

    suspend fun getAccessToken(): String? {
        return withContext(Dispatchers.IO) {
            try {
                // Check if token is still valid (with 5 minute buffer)
                if (accessToken != null && System.currentTimeMillis() < tokenExpiry - 300000) {
                    Log.d(TAG, "✅ Using cached access token")
                    return@withContext accessToken
                }

                Log.d(TAG, "🔄 Refreshing Firebase access token...")

                // Load service account credentials from assets
                val inputStream = context.assets.open("firebase-service-account.json")
                val credentials = GoogleCredentials.fromStream(inputStream)
                    .createScoped(listOf("https://www.googleapis.com/auth/firebase.messaging"))

                // Refresh the token in IO context
                credentials.refresh()

                val tokenValue = credentials.accessToken?.tokenValue
                if (tokenValue != null) {
                    accessToken = tokenValue
                    tokenExpiry = credentials.accessToken?.expirationTime?.time ?: (System.currentTimeMillis() + 3600000)

                    Log.d(TAG, "✅ Access token refreshed successfully")
                    Log.d(TAG, "🕒 Token expires at: ${java.util.Date(tokenExpiry)}")

                    accessToken
                } else {
                    Log.e(TAG, "❌ Failed to get token value from credentials")
                    null
                }
            } catch (e: Exception) {
                Log.e(TAG, "❌ Error getting access token", e)
                null
            }
        }
    }

    suspend fun sendNotificationToTokens(
        tokens: List<String>,
        title: String,
        body: String,
        data: Map<String, String> = emptyMap()
    ): Result<Int> {
        return withContext(Dispatchers.IO) {
            try {
                val accessToken = getAccessToken()
                if (accessToken == null) {
                    return@withContext Result.failure(Exception("Failed to get Firebase access token"))
                }

                Log.d(TAG, "🚀 Sending notifications to ${tokens.size} devices using Firebase Admin API")

                var successCount = 0
                var failureCount = 0

                // Send to each token individually for better error handling
                tokens.forEachIndexed { index, token ->
                    try {
                        Log.d(TAG, "📱 Sending to device ${index + 1}/${tokens.size}")
                        val success = sendToSingleToken(accessToken, token, title, body, data)
                        if (success) {
                            successCount++
                            Log.d(TAG, "✅ Success for device ${index + 1}")
                        } else {
                            failureCount++
                            Log.w(TAG, "❌ Failed for device ${index + 1}")
                        }
                    } catch (e: Exception) {
                        failureCount++
                        Log.e(TAG, "💥 Exception for device ${index + 1}: ${e.message}")
                    }
                }

                Log.d(TAG, "📊 Results: ✅ $successCount success, ❌ $failureCount failures")

                if (successCount > 0) {
                    Result.success(successCount)
                } else {
                    Result.failure(Exception("Failed to send notifications to any devices"))
                }

            } catch (e: Exception) {
                Log.e(TAG, "💥 Error in sendNotificationToTokens", e)
                Result.failure(e)
            }
        }
    }

    private fun sendToSingleToken(
        accessToken: String,
        token: String,
        title: String,
        body: String,
        data: Map<String, String>
    ): Boolean {
        return try {
            val projectId = "time-c74a6" // Your Firebase project ID
            val url = URL("https://fcm.googleapis.com/v1/projects/$projectId/messages:send")
            val connection = url.openConnection() as HttpURLConnection

            connection.requestMethod = "POST"
            connection.setRequestProperty("Authorization", "Bearer $accessToken")
            connection.setRequestProperty("Content-Type", "application/json")
            connection.doOutput = true
            connection.connectTimeout = 15000
            connection.readTimeout = 15000

            // Create FCM v1 API payload
            val message = JSONObject().apply {
                put("token", token)

                // Notification payload
                put("notification", JSONObject().apply {
                    put("title", title)
                    put("body", body)
                })

                // Data payload
                if (data.isNotEmpty()) {
                    put("data", JSONObject().apply {
                        data.forEach { (key, value) ->
                            put(key, value)
                        }
                        put("title", title)
                        put("body", body)
                        put("timestamp", System.currentTimeMillis().toString())
                    })
                }

                // Android specific configuration
                put("android", JSONObject().apply {
                    put("priority", "high")
                    put("notification", JSONObject().apply {
                        put("channel_id", "timetable_notifications")
                        put("sound", "default")
                    })
                })
            }

            val payload = JSONObject().apply {
                put("message", message)
            }

            Log.d(TAG, "📤 Sending payload: $payload")

            // Send the request
            val writer = OutputStreamWriter(connection.outputStream)
            writer.write(payload.toString())
            writer.flush()
            writer.close()

            val responseCode = connection.responseCode
            val responseMessage = connection.responseMessage

            Log.d(TAG, "📥 Response: $responseCode - $responseMessage")

            when (responseCode) {
                200 -> {
                    val response = connection.inputStream.bufferedReader().readText()
                    Log.d(TAG, "✅ Success response: $response")
                    true
                }
                400 -> {
                    val errorResponse = connection.errorStream?.bufferedReader()?.readText()
                    Log.e(TAG, "❌ Bad Request (400): $errorResponse")
                    Log.e(TAG, "💡 Check your payload format and FCM token validity")
                    false
                }
                401 -> {
                    Log.e(TAG, "❌ Unauthorized (401): Access token may be expired")
                    // Clear cached token to force refresh
                    this@FirebaseAdminService.accessToken = null
                    false
                }
                403 -> {
                    val errorResponse = connection.errorStream?.bufferedReader()?.readText()
                    Log.e(TAG, "❌ Forbidden (403): $errorResponse")
                    Log.e(TAG, "💡 Check Firebase project permissions")
                    false
                }
                404 -> {
                    Log.e(TAG, "❌ Not Found (404): Invalid FCM token or project ID")
                    false
                }
                else -> {
                    val errorResponse = connection.errorStream?.bufferedReader()?.readText()
                    Log.e(TAG, "❌ Error ($responseCode): $errorResponse")
                    false
                }
            }

        } catch (e: Exception) {
            Log.e(TAG, "💥 Exception sending notification", e)
            false
        }
    }
}
