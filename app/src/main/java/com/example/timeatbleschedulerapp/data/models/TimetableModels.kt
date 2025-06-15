package com.example.timeatbleschedulerapp.data.models

data class TimetableEntry(
    val id: String = "",
    val groupId: String = "",
    val subjectId: String = "",
    val subjectName: String = "",
    val teacherId: String = "",
    val teacherName: String = "",
    val roomId: String = "",
    val day: String = "",
    val dayOfWeek: String = "", // Added this property
    val startTime: String = "",
    val endTime: String = "",
    val type: String = "", // "lecture" or "lab"
    val students: Int = 0
)

data class GeneratedTimetable(
    val id: String = "",
    val generatedAt: Long = System.currentTimeMillis(),
    val fitnessScore: Int = 0,
    val totalClasses: Int = 0,
    val generationsRun: Int = 0,
    val improvementPercentage: Double = 0.0,
    val entries: List<TimetableEntry> = emptyList(),
    val isActive: Boolean = false
)

data class Subject(
    val id: String = "",
    val name: String = "",
    val hoursPerWeek: Int = 0,
    val labRequired: Boolean = false
)

data class Teacher(
    val id: String = "",
    val name: String = "",
    val subjects: List<String> = emptyList(),
    val maxHours: Int = 0
)

data class Room(
    val id: String = "",
    val type: String = "", // "lecture" or "lab"
    val capacity: Int = 0
)

data class StudentGroup(
    val id: String = "",
    val semester: Int = 0,
    val students: Int = 0,
    val subjects: List<String> = emptyList()
)
