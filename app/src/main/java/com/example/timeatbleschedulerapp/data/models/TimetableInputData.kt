package com.example.timeatbleschedulerapp.data.models

enum class DayOfWeek {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

enum class SubjectType {
    THEORY, PRACTICAL, TUTORIAL, SEMINAR
}

enum class RoomType {
    LECTURE_HALL, LABORATORY, TUTORIAL_ROOM, SEMINAR_HALL
}

data class TeacherInput(
    val id: String = java.util.UUID.randomUUID().toString(),
    val teacherId: String = "",
    val name: String = "",
    val email: String = "",
    val phone: String = "",
    val subjects: List<String> = emptyList(),
    val availableDays: List<DayOfWeek> = emptyList(),
    val preferredTimeSlots: List<String> = emptyList(),
    val maxHoursPerWeek: Int = 20
)

data class SubjectInput(
    val id: String = java.util.UUID.randomUUID().toString(),
    val subjectId: String = "",
    val name: String = "",
    val code: String = "",
    val hoursPerWeek: Int = 3,
    val type: SubjectType = SubjectType.THEORY,
    val requiresLab: Boolean = false,
    val requiresProjector: Boolean = false
)

data class RoomInput(
    val id: String = java.util.UUID.randomUUID().toString(),
    val roomId: String = "",
    val number: String = "",
    val name: String = "",
    val capacity: Int = 30,
    val type: RoomType = RoomType.LECTURE_HALL,
    val hasProjector: Boolean = false,
    val hasComputers: Boolean = false,
    val hasWhiteboard: Boolean = true
)

data class StudentGroupInput(
    val id: String = java.util.UUID.randomUUID().toString(),
    val groupId: String = "",
    val name: String = "",
    val code: String = "",
    val semester: Int = 1,
    val studentCount: Int = 30,
    val subjects: List<String> = emptyList()
)

data class TimeSlotInput(
    val slotId: String = "",
    val day: String = "",
    val startTime: String = "",
    val endTime: String = "",
    val duration: Int = 60
)

data class TimetableConstraints(
    val maxClassesPerDay: Int = 6,
    val minBreakBetweenClasses: Int = 15,
    val preferMorningClasses: Boolean = true,
    val avoidBackToBackLabs: Boolean = true
)

data class TimetableInputData(
    val dataId: String = "",
    val teachers: List<TeacherInput> = emptyList(),
    val subjects: List<SubjectInput> = emptyList(),
    val rooms: List<RoomInput> = emptyList(),
    val studentGroups: List<StudentGroupInput> = emptyList(),
    val timeSlots: List<TimeSlotInput> = emptyList(),
    val constraints: TimetableConstraints = TimetableConstraints(),
    val createdBy: String = "",
    val createdAt: Long = System.currentTimeMillis()
)
