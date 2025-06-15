package com.example.timeatbleschedulerapp.ui.screens.notifications

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timeatbleschedulerapp.data.models.Notification
import com.example.timeatbleschedulerapp.data.repository.AuthRepository
import com.example.timeatbleschedulerapp.data.repository.NotificationRepository
import com.example.timeatbleschedulerapp.utils.NotificationDebugHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "NotificationsViewModel"

@HiltViewModel
class NotificationsViewModel @Inject constructor(
    private val notificationRepository: NotificationRepository,
    private val authRepository: AuthRepository,
    private val debugHelper: NotificationDebugHelper
) : ViewModel() {

    private val _notifications = MutableLiveData<List<Notification>>()
    val notifications: LiveData<List<Notification>> = _notifications

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    init {
        loadNotifications()
    }

    fun loadNotifications() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                _error.value = null

                Log.d(TAG, "Starting to load notifications...")

                // Run debug helper
                debugHelper.debugNotificationFlow()

                val currentUserId = authRepository.getCurrentUserId()
                Log.d(TAG, "Current user ID: $currentUserId")

                if (currentUserId == null) {
                    _error.value = "User not authenticated"
                    Log.e(TAG, "User not authenticated")
                    return@launch
                }

                val result = notificationRepository.getNotificationsForUser(currentUserId)
                if (result.isSuccess) {
                    val notificationsList = result.getOrThrow()
                    _notifications.value = notificationsList
                    Log.d(TAG, "Successfully loaded ${notificationsList.size} notifications")

                    // Log each notification for debugging
                    notificationsList.forEach { notification ->
                        Log.d(TAG, "Notification: ${notification.title} - ${notification.message}")
                    }
                } else {
                    val exception = result.exceptionOrNull()
                    _error.value = exception?.message ?: "Failed to load notifications"
                    Log.e(TAG, "Error loading notifications", exception)
                }
            } catch (e: Exception) {
                _error.value = e.message ?: "Failed to load notifications"
                Log.e(TAG, "Exception in loadNotifications", e)
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun markAsRead(notification: Notification) {
        if (notification.isRead) return

        viewModelScope.launch {
            try {
                val result = notificationRepository.markNotificationAsRead(notification.id)
                if (result.isSuccess) {
                    // Update the local list
                    val currentList = _notifications.value?.toMutableList() ?: return@launch
                    val index = currentList.indexOfFirst { it.id == notification.id }
                    if (index != -1) {
                        currentList[index] = notification.copy(isRead = true)
                        _notifications.value = currentList
                        Log.d(TAG, "Marked notification as read: ${notification.id}")
                    }
                } else {
                    Log.e(TAG, "Failed to mark notification as read: ${result.exceptionOrNull()?.message}")
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error marking notification as read", e)
            }
        }
    }

    fun refreshNotifications() {
        Log.d(TAG, "Refreshing notifications...")
        loadNotifications()
    }

    fun debugNotifications() {
        viewModelScope.launch {
            debugHelper.debugNotificationFlow()
        }
    }
}
