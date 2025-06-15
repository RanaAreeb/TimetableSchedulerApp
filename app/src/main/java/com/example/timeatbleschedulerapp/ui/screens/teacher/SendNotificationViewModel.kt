package com.example.timeatbleschedulerapp.ui.screens.teacher

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timeatbleschedulerapp.data.repository.AuthRepository
import com.example.timeatbleschedulerapp.data.repository.NotificationRepository
import com.example.timeatbleschedulerapp.services.NotificationManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "SendNotificationVM"

@HiltViewModel
class SendNotificationViewModel @Inject constructor(
    private val notificationManager: NotificationManager,
    private val notificationRepository: NotificationRepository,
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _notificationState = MutableLiveData<NotificationState>(NotificationState.Idle)
    val notificationState: LiveData<NotificationState> = _notificationState

    fun sendNotification(title: String, message: String, recipientType: String, recipientId: String) {
        viewModelScope.launch {
            try {
                _notificationState.value = NotificationState.Loading

                // Get current user (sender)
                val currentUser = authRepository.getCurrentUser()
                if (currentUser == null) {
                    _notificationState.value = NotificationState.Error("User not authenticated")
                    return@launch
                }

                Log.d(TAG, "Sending notification: $title to $recipientType ($recipientId)")

                // Get recipient IDs based on type
                val recipientIds = when (recipientType) {
                    "All Students" -> {
                        val studentsResult = notificationRepository.getAllStudents()
                        if (studentsResult.isSuccess) {
                            studentsResult.getOrThrow().map { it.id }
                        } else {
                            _notificationState.value = NotificationState.Error("Failed to get students")
                            return@launch
                        }
                    }
                    "Specific Batch" -> {
                        val studentsResult = notificationRepository.getStudentsByBatch(recipientId)
                        if (studentsResult.isSuccess) {
                            studentsResult.getOrThrow().map { it.id }
                        } else {
                            _notificationState.value = NotificationState.Error("Failed to get batch students")
                            return@launch
                        }
                    }
                    "Individual Student" -> {
                        listOf(recipientId) // Assuming recipientId is the student ID
                    }
                    else -> {
                        _notificationState.value = NotificationState.Error("Invalid recipient type")
                        return@launch
                    }
                }

                if (recipientIds.isEmpty()) {
                    _notificationState.value = NotificationState.Error("No recipients found")
                    return@launch
                }

                // Send complete notification (Firestore + FCM)
                val result = notificationManager.sendCompleteNotification(
                    title = title,
                    message = message,
                    senderId = currentUser.id,
                    senderName = currentUser.name,
                    recipientIds = recipientIds
                )

                if (result.isSuccess) {
                    Log.d(TAG, "Complete notification sent successfully to ${recipientIds.size} recipients")
                    _notificationState.value = NotificationState.Success
                } else {
                    val error = result.exceptionOrNull()
                    Log.e(TAG, "Failed to send notification", error)
                    _notificationState.value = NotificationState.Error(error?.message ?: "Failed to send notification")
                }

            } catch (e: Exception) {
                Log.e(TAG, "Error sending notification", e)
                _notificationState.value = NotificationState.Error(e.message ?: "Failed to send notification")
            }
        }
    }
}

sealed class NotificationState {
    object Idle : NotificationState()
    object Loading : NotificationState()
    object Success : NotificationState()
    data class Error(val message: String) : NotificationState()
}
