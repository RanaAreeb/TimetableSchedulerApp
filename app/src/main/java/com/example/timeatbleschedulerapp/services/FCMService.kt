package com.example.timeatbleschedulerapp.services

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.timeatbleschedulerapp.MainActivity
import com.example.timeatbleschedulerapp.R
import com.example.timeatbleschedulerapp.data.repository.FCMRepository
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "FCMService"
private const val CHANNEL_ID = "timetable_notifications"

@AndroidEntryPoint
class FCMService : FirebaseMessagingService() {

    @Inject
    lateinit var fcmRepository: FCMRepository

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
        Log.d(TAG, "FCMService created and notification channel set up")
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

        Log.d(TAG, "=== FCM Message Received ===")
        Log.d(TAG, "From: ${remoteMessage.from}")
        Log.d(TAG, "Message ID: ${remoteMessage.messageId}")
        Log.d(TAG, "Data: ${remoteMessage.data}")
        Log.d(TAG, "Notification: ${remoteMessage.notification}")

        // Always show notification regardless of app state
        val title = remoteMessage.notification?.title
            ?: remoteMessage.data["title"]
            ?: "New Notification"

        val body = remoteMessage.notification?.body
            ?: remoteMessage.data["body"]
            ?: remoteMessage.data["message"]
            ?: ""

        Log.d(TAG, "Displaying notification: $title - $body")
        showNotification(title, body, remoteMessage.data)
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d(TAG, "=== New FCM Token Received ===")
        Log.d(TAG, "Token: $token")

        // Update token in Firestore
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val result = fcmRepository.updateFCMToken()
                if (result.isSuccess) {
                    Log.d(TAG, "FCM token updated successfully in Firestore")
                } else {
                    Log.e(TAG, "Failed to update FCM token: ${result.exceptionOrNull()?.message}")
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error updating FCM token", e)
            }
        }
    }

    private fun showNotification(title: String, body: String, data: Map<String, String>) {
        Log.d(TAG, "Creating notification with title: $title, body: $body")

        val intent = Intent(this, MainActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            // Add notification data to intent
            data.forEach { (key, value) ->
                putExtra(key, value)
            }
            putExtra("from_notification", true)
        }

        val pendingIntent = PendingIntent.getActivity(
            this,
            System.currentTimeMillis().toInt(),
            intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )

        val notificationBuilder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_notifications)
            .setContentTitle(title)
            .setContentText(body)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setDefaults(NotificationCompat.DEFAULT_ALL)
            .setStyle(NotificationCompat.BigTextStyle().bigText(body))
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val notificationId = System.currentTimeMillis().toInt()

        try {
            notificationManager.notify(notificationId, notificationBuilder.build())
            Log.d(TAG, "Notification displayed successfully with ID: $notificationId")
        } catch (e: Exception) {
            Log.e(TAG, "Error displaying notification", e)
        }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Timetable Notifications",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Notifications for timetable updates and announcements"
                enableLights(true)
                enableVibration(true)
                setShowBadge(true)
                lockscreenVisibility = android.app.Notification.VISIBILITY_PUBLIC
            }

            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
            Log.d(TAG, "Notification channel '$CHANNEL_ID' created successfully")
        }
    }
}
