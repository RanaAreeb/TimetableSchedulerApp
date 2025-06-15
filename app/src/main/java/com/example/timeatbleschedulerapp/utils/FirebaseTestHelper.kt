package com.example.timeatbleschedulerapp.utils

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

object FirebaseTestHelper {
    private const val TAG = "FirebaseTestHelper"

    suspend fun testFirebaseConnection(): Boolean {
        return try {
            Log.d(TAG, "Testing Firebase connection...")

            // Test Firestore connection
            val firestore = FirebaseFirestore.getInstance()
            firestore.collection("test").limit(1).get().await()

            Log.d(TAG, "Firebase connection test successful")
            true
        } catch (e: Exception) {
            Log.e(TAG, "Firebase connection test failed: ${e.message}")
            false
        }
    }

    fun getFirebaseAuthStatus(): String {
        val auth = FirebaseAuth.getInstance()
        return "Auth instance: ${auth.app.name}, Current user: ${auth.currentUser?.uid ?: "None"}"
    }
}
