package com.example.timeatbleschedulerapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import com.example.timeatbleschedulerapp.ui.screens.onboarding.OnboardingActivity
import com.example.timeatbleschedulerapp.utils.NotificationPermissionHelper
import com.google.firebase.FirebaseApp
import com.google.firebase.messaging.FirebaseMessaging
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

private const val TAG = "MainActivity"

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            // Initialize Firebase
            FirebaseApp.initializeApp(this)
            Log.d(TAG, "Firebase initialized successfully")

            // Request notification permission
            requestNotificationPermission()

            // Initialize FCM
            initializeFCM()

            // Check if opened from notification
            handleNotificationIntent(intent)

            // Navigate to onboarding
            val intent = Intent(this, OnboardingActivity::class.java)
            startActivity(intent)
            finish()
        } catch (e: Exception) {
            Log.e(TAG, "Error initializing app", e)
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        handleNotificationIntent(intent)
    }

    private fun requestNotificationPermission() {
        if (!NotificationPermissionHelper.hasNotificationPermission(this)) {
            Log.d(TAG, "Requesting notification permission")
            NotificationPermissionHelper.requestNotificationPermission(this)
        } else {
            Log.d(TAG, "Notification permission already granted")
        }
    }

    private fun initializeFCM() {
        lifecycleScope.launch {
            try {
                val token = FirebaseMessaging.getInstance().token.await()
                Log.d(TAG, "FCM Token obtained: $token")

                // Subscribe to general topic for testing
                FirebaseMessaging.getInstance().subscribeToTopic("general")
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Log.d(TAG, "Subscribed to general topic")
                        } else {
                            Log.e(TAG, "Failed to subscribe to topic", task.exception)
                        }
                    }

            } catch (e: Exception) {
                Log.e(TAG, "Error getting FCM token", e)
            }
        }
    }

    private fun handleNotificationIntent(intent: Intent?) {
        if (intent?.getBooleanExtra("from_notification", false) == true) {
            Log.d(TAG, "App opened from notification")
            val notificationId = intent.getStringExtra("notificationId")
            val senderName = intent.getStringExtra("senderName")

            if (notificationId != null) {
                Log.d(TAG, "Notification ID: $notificationId, Sender: $senderName")
                // You can navigate to specific screen or show notification details
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        NotificationPermissionHelper.handlePermissionResult(
            requestCode, permissions, grantResults,
            onGranted = {
                Toast.makeText(this, "Notification permission granted", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "Notification permission granted by user")
            },
            onDenied = {
                Toast.makeText(this, "Notification permission denied", Toast.LENGTH_LONG).show()
                Log.w(TAG, "Notification permission denied by user")
            }
        )
    }
}
