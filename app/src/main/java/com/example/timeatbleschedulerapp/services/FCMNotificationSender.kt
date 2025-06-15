package com.example.timeatbleschedulerapp.services

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL
import javax.inject.Inject
import javax.inject.Singleton

private const val TAG = "FCMNotificationSender"

@Singleton
class FCMNotificationSender @Inject constructor() {

    // You'll need to get this from Firebase Console -> Project Settings -> Cloud Messaging -> Server Key
    private val serverKey = "YOUR_SERVER_KEY_HERE" // Replace with actual server key

    suspend fun sendNotificationToTokens(
        tokens: List<String>,
        title: String,
        body: String,
        data: Map<String, String> = emptyMap()
    ): Result<Int> {
        return withContext(Dispatchers.IO) {
            try {
                var successCount = 0
                var failureCount = 0

                // Send to each token individually (for better error handling)
                tokens.forEach { token ->
                    try {
                        val success = sendToSingleToken(token, title, body, data)
                        if (success) {
                            successCount++
                            Log.d(TAG, "Successfully sent to token: ${token.take(10)}...")
                        } else {
                            failureCount++
                            Log.w(TAG, "Failed to send to token: ${token.take(10)}...")
                        }
                    } catch (e: Exception) {
                        failureCount++
                        Log.e(TAG, "Error sending to token: ${token.take(10)}...", e)
                    }
                }

                Log.d(TAG, "FCM sending complete. Success: $successCount, Failures: $failureCount")

                if (successCount > 0) {
                    Result.success(successCount)
                } else {
                    Result.failure(Exception("Failed to send to any devices"))
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error in sendNotificationToTokens", e)
                Result.failure(e)
            }
        }
    }

    private suspend fun sendToSingleToken(
        token: String,
        title: String,
        body: String,
        data: Map<String, String>
    ): Boolean {
        return try {
            val url = URL("https://fcm.googleapis.com/fcm/send")
            val connection = url.openConnection() as HttpURLConnection

            connection.requestMethod = "POST"
            connection.setRequestProperty("Authorization", "key=$serverKey")
            connection.setRequestProperty("Content-Type", "application/json")
            connection.doOutput = true
            connection.connectTimeout = 10000
            connection.readTimeout = 10000

            val payload = JSONObject().apply {
                put("to", token)

                // Notification payload for display when app is in background
                put("notification", JSONObject().apply {
                    put("title", title)
                    put("body", body)
                    put("icon", "ic_notifications")
                    put("sound", "default")
                    put("click_action", "FLUTTER_NOTIFICATION_CLICK")
                })

                // Data payload for custom handling
                put("data", JSONObject().apply {
                    put("title", title)
                    put("body", body)
                    put("type", "timetable_notification")
                    data.forEach { (key, value) ->
                        put(key, value)
                    }
                })

                // Android specific options
                put("android", JSONObject().apply {
                    put("priority", "high")
                    put("notification", JSONObject().apply {
                        put("channel_id", "timetable_notifications")
                        put("priority", "high")
                        put("default_sound", true)
                        put("default_vibrate_timings", true)
                    })
                })
            }

            Log.d(TAG, "Sending FCM payload: $payload")

            val writer = OutputStreamWriter(connection.outputStream)
            writer.write(payload.toString())
            writer.flush()
            writer.close()

            val responseCode = connection.responseCode
            val responseMessage = connection.responseMessage

            Log.d(TAG, "FCM Response: $responseCode - $responseMessage")

            if (responseCode == 200) {
                val response = connection.inputStream.bufferedReader().readText()
                Log.d(TAG, "FCM Success Response: $response")
                true
            } else {
                val errorResponse = connection.errorStream?.bufferedReader()?.readText()
                Log.e(TAG, "FCM Error Response: $errorResponse")
                false
            }

        } catch (e: Exception) {
            Log.e(TAG, "Exception sending FCM to token", e)
            false
        }
    }
}
