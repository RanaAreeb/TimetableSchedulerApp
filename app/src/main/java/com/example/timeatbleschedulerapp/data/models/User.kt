package com.example.timeatbleschedulerapp.data.models

data class User(
    val id: String = "",
    val email: String = "",
    val name: String = "",
    val role: UserRole = UserRole.STUDENT,
    val batchId: String = "",
    val profileImageUrl: String = "",
    val fcmToken: String = ""
)

enum class UserRole {
    STUDENT,
    TEACHER,
    BATCH_COORDINATOR
}

data class Batch(
    val id: String = "",
    val name: String = "",
    val coordinatorId: String = "",
    val studentIds: List<String> = emptyList(),
    val teacherIds: List<String> = emptyList()
)

data class Notification(
    val id: String = "",
    val title: String = "",
    val message: String = "",
    val senderId: String = "",
    val senderName: String = "",
    val recipientIds: List<String> = emptyList(),
    val timestamp: Long = 0L,
    val isRead: Boolean = false
)
