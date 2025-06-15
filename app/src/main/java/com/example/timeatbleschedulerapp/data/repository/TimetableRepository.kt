package com.example.timeatbleschedulerapp.data.repository

import com.example.timeatbleschedulerapp.data.models.*
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TimetableRepository @Inject constructor(
    private val firestore: FirebaseFirestore
) {

    private val timetablesCollection = firestore.collection("timetables")
    private val entriesCollection = firestore.collection("timetable_entries")
    private val teachersCollection = firestore.collection("teachers")
    private val subjectsCollection = firestore.collection("subjects")
    private val roomsCollection = firestore.collection("rooms")
    private val studentGroupsCollection = firestore.collection("student_groups")
    private val inputDataCollection = firestore.collection("timetable_input_data")

    // Timetable methods
    suspend fun saveTimetable(timetable: GeneratedTimetable) {
        try {
            timetablesCollection.document(timetable.id).set(
                mapOf(
                    "id" to timetable.id,
                    "generatedAt" to timetable.generatedAt,
                    "fitnessScore" to timetable.fitnessScore,
                    "totalClasses" to timetable.totalClasses,
                    "generationsRun" to timetable.generationsRun,
                    "improvementPercentage" to timetable.improvementPercentage,
                    "isActive" to timetable.isActive
                )
            ).await()

            val batch = firestore.batch()
            timetable.entries.forEach { entry ->
                val entryDoc = entriesCollection.document("${timetable.id}_${entry.id}")
                batch.set(entryDoc, mapOf(
                    "id" to entry.id,
                    "timetableId" to timetable.id,
                    "groupId" to entry.groupId,
                    "subjectId" to entry.subjectId,
                    "subjectName" to entry.subjectName,
                    "teacherId" to entry.teacherId,
                    "teacherName" to entry.teacherName,
                    "roomId" to entry.roomId,
                    "day" to entry.day,
                    "dayOfWeek" to entry.dayOfWeek,
                    "startTime" to entry.startTime,
                    "endTime" to entry.endTime,
                    "type" to entry.type,
                    "students" to entry.students
                ))
            }
            batch.commit().await()

        } catch (e: Exception) {
            throw Exception("Failed to save timetable: ${e.message}")
        }
    }

    suspend fun getTimetable(timetableId: String): GeneratedTimetable? {
        return try {
            val timetableDoc = timetablesCollection.document(timetableId).get().await()
            if (timetableDoc.exists()) {
                val entries = getEntriesForTimetable(timetableId)
                GeneratedTimetable(
                    id = timetableDoc.getString("id") ?: "",
                    generatedAt = timetableDoc.getLong("generatedAt") ?: 0L,
                    fitnessScore = timetableDoc.getLong("fitnessScore")?.toInt() ?: 0,
                    totalClasses = timetableDoc.getLong("totalClasses")?.toInt() ?: 0,
                    generationsRun = timetableDoc.getLong("generationsRun")?.toInt() ?: 0,
                    improvementPercentage = timetableDoc.getDouble("improvementPercentage") ?: 0.0,
                    isActive = timetableDoc.getBoolean("isActive") ?: false,
                    entries = entries
                )
            } else null
        } catch (e: Exception) {
            null
        }
    }

    private suspend fun getEntriesForTimetable(timetableId: String): List<TimetableEntry> {
        return try {
            val entriesSnapshot = entriesCollection
                .whereEqualTo("timetableId", timetableId)
                .get()
                .await()

            entriesSnapshot.documents.map { doc ->
                TimetableEntry(
                    id = doc.getString("id") ?: "",
                    groupId = doc.getString("groupId") ?: "",
                    subjectId = doc.getString("subjectId") ?: "",
                    subjectName = doc.getString("subjectName") ?: "",
                    teacherId = doc.getString("teacherId") ?: "",
                    teacherName = doc.getString("teacherName") ?: "",
                    roomId = doc.getString("roomId") ?: "",
                    day = doc.getString("day") ?: "",
                    dayOfWeek = doc.getString("dayOfWeek") ?: "",
                    startTime = doc.getString("startTime") ?: "",
                    endTime = doc.getString("endTime") ?: "",
                    type = doc.getString("type") ?: "",
                    students = doc.getLong("students")?.toInt() ?: 0
                )
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun getTimetableForBatch(batchId: String): List<TimetableEntry> {
        return try {
            val entriesSnapshot = entriesCollection
                .whereEqualTo("groupId", batchId)
                .get()
                .await()

            entriesSnapshot.documents.map { doc ->
                TimetableEntry(
                    id = doc.getString("id") ?: "",
                    groupId = doc.getString("groupId") ?: "",
                    subjectId = doc.getString("subjectId") ?: "",
                    subjectName = doc.getString("subjectName") ?: "",
                    teacherId = doc.getString("teacherId") ?: "",
                    teacherName = doc.getString("teacherName") ?: "",
                    roomId = doc.getString("roomId") ?: "",
                    day = doc.getString("day") ?: "",
                    dayOfWeek = doc.getString("dayOfWeek") ?: "",
                    startTime = doc.getString("startTime") ?: "",
                    endTime = doc.getString("endTime") ?: "",
                    type = doc.getString("type") ?: "",
                    students = doc.getLong("students")?.toInt() ?: 0
                )
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun getTimetableForTeacher(teacherId: String): List<TimetableEntry> {
        return try {
            val entriesSnapshot = entriesCollection
                .whereEqualTo("teacherId", teacherId)
                .get()
                .await()

            entriesSnapshot.documents.map { doc ->
                TimetableEntry(
                    id = doc.getString("id") ?: "",
                    groupId = doc.getString("groupId") ?: "",
                    subjectId = doc.getString("subjectId") ?: "",
                    subjectName = doc.getString("subjectName") ?: "",
                    teacherId = doc.getString("teacherId") ?: "",
                    teacherName = doc.getString("teacherName") ?: "",
                    roomId = doc.getString("roomId") ?: "",
                    day = doc.getString("day") ?: "",
                    dayOfWeek = doc.getString("dayOfWeek") ?: "",
                    startTime = doc.getString("startTime") ?: "",
                    endTime = doc.getString("endTime") ?: "",
                    type = doc.getString("type") ?: "",
                    students = doc.getLong("students")?.toInt() ?: 0
                )
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun getAllTimetables(): List<TimetableEntry> {
        return try {
            val entriesSnapshot = entriesCollection.get().await()

            entriesSnapshot.documents.map { doc ->
                TimetableEntry(
                    id = doc.getString("id") ?: "",
                    groupId = doc.getString("groupId") ?: "",
                    subjectId = doc.getString("subjectId") ?: "",
                    subjectName = doc.getString("subjectName") ?: "",
                    teacherId = doc.getString("teacherId") ?: "",
                    teacherName = doc.getString("teacherName") ?: "",
                    roomId = doc.getString("roomId") ?: "",
                    day = doc.getString("day") ?: "",
                    dayOfWeek = doc.getString("dayOfWeek") ?: "",
                    startTime = doc.getString("startTime") ?: "",
                    endTime = doc.getString("endTime") ?: "",
                    type = doc.getString("type") ?: "",
                    students = doc.getLong("students")?.toInt() ?: 0
                )
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    // Input data methods
    suspend fun saveTeacher(teacher: TeacherInput) {
        try {
            teachersCollection.document(teacher.teacherId).set(
                mapOf(
                    "teacherId" to teacher.teacherId,
                    "name" to teacher.name,
                    "email" to teacher.email,
                    "phone" to teacher.phone,
                    "subjects" to teacher.subjects,
                    "availableDays" to teacher.availableDays.map { it.name },
                    "preferredTimeSlots" to teacher.preferredTimeSlots,
                    "maxHoursPerWeek" to teacher.maxHoursPerWeek
                )
            ).await()
        } catch (e: Exception) {
            throw Exception("Failed to save teacher: ${e.message}")
        }
    }

    suspend fun saveSubject(subject: SubjectInput) {
        try {
            subjectsCollection.document(subject.subjectId).set(
                mapOf(
                    "subjectId" to subject.subjectId,
                    "name" to subject.name,
                    "code" to subject.code,
                    "hoursPerWeek" to subject.hoursPerWeek,
                    "type" to subject.type.name,
                    "requiresLab" to subject.requiresLab,
                    "requiresProjector" to subject.requiresProjector
                )
            ).await()
        } catch (e: Exception) {
            throw Exception("Failed to save subject: ${e.message}")
        }
    }

    suspend fun saveRoom(room: RoomInput) {
        try {
            roomsCollection.document(room.roomId).set(
                mapOf(
                    "roomId" to room.roomId,
                    "number" to room.number,
                    "name" to room.name,
                    "capacity" to room.capacity,
                    "type" to room.type.name,
                    "hasProjector" to room.hasProjector,
                    "hasComputers" to room.hasComputers,
                    "hasWhiteboard" to room.hasWhiteboard
                )
            ).await()
        } catch (e: Exception) {
            throw Exception("Failed to save room: ${e.message}")
        }
    }

    suspend fun saveStudentGroup(group: StudentGroupInput) {
        try {
            studentGroupsCollection.document(group.groupId).set(
                mapOf(
                    "groupId" to group.groupId,
                    "name" to group.name,
                    "code" to group.code,
                    "semester" to group.semester,
                    "studentCount" to group.studentCount,
                    "subjects" to group.subjects
                )
            ).await()
        } catch (e: Exception) {
            throw Exception("Failed to save student group: ${e.message}")
        }
    }

    suspend fun getTimetableInputData(): TimetableInputData? {
        return try {
            val dataSnapshot = inputDataCollection.limit(1).get().await()
            if (dataSnapshot.documents.isNotEmpty()) {
                val doc = dataSnapshot.documents.first()
                TimetableInputData(
                    dataId = doc.getString("dataId") ?: "",
                    teachers = getTeachers(),
                    subjects = getSubjects(),
                    rooms = getRooms(),
                    studentGroups = getStudentGroups(),
                    timeSlots = getTimeSlots(),
                    constraints = TimetableConstraints(),
                    createdBy = doc.getString("createdBy") ?: "",
                    createdAt = doc.getLong("createdAt") ?: 0L
                )
            } else null
        } catch (e: Exception) {
            null
        }
    }

    suspend fun saveTimetableInputData(data: TimetableInputData) {
        try {
            inputDataCollection.document(data.dataId).set(
                mapOf(
                    "dataId" to data.dataId,
                    "createdBy" to data.createdBy,
                    "createdAt" to data.createdAt
                )
            ).await()
        } catch (e: Exception) {
            throw Exception("Failed to save timetable input data: ${e.message}")
        }
    }

    private suspend fun getTeachers(): List<TeacherInput> {
        return try {
            val snapshot = teachersCollection.get().await()
            snapshot.documents.map { doc ->
                TeacherInput(
                    teacherId = doc.getString("teacherId") ?: "",
                    name = doc.getString("name") ?: "",
                    email = doc.getString("email") ?: "",
                    phone = doc.getString("phone") ?: "",
                    subjects = doc.get("subjects") as? List<String> ?: emptyList(),
                    availableDays = (doc.get("availableDays") as? List<String> ?: emptyList())
                        .mapNotNull { dayName -> DayOfWeek.values().find { it.name == dayName } },
                    preferredTimeSlots = doc.get("preferredTimeSlots") as? List<String> ?: emptyList(),
                    maxHoursPerWeek = doc.getLong("maxHoursPerWeek")?.toInt() ?: 20
                )
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    private suspend fun getSubjects(): List<SubjectInput> {
        return try {
            val snapshot = subjectsCollection.get().await()
            snapshot.documents.map { doc ->
                SubjectInput(
                    subjectId = doc.getString("subjectId") ?: "",
                    name = doc.getString("name") ?: "",
                    code = doc.getString("code") ?: "",
                    hoursPerWeek = doc.getLong("hoursPerWeek")?.toInt() ?: 3,
                    type = SubjectType.valueOf(doc.getString("type") ?: "THEORY"),
                    requiresLab = doc.getBoolean("requiresLab") ?: false,
                    requiresProjector = doc.getBoolean("requiresProjector") ?: false
                )
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    private suspend fun getRooms(): List<RoomInput> {
        return try {
            val snapshot = roomsCollection.get().await()
            snapshot.documents.map { doc ->
                RoomInput(
                    roomId = doc.getString("roomId") ?: "",
                    number = doc.getString("number") ?: "",
                    name = doc.getString("name") ?: "",
                    capacity = doc.getLong("capacity")?.toInt() ?: 30,
                    type = RoomType.valueOf(doc.getString("type") ?: "LECTURE_HALL"),
                    hasProjector = doc.getBoolean("hasProjector") ?: false,
                    hasComputers = doc.getBoolean("hasComputers") ?: false,
                    hasWhiteboard = doc.getBoolean("hasWhiteboard") ?: true
                )
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    private suspend fun getStudentGroups(): List<StudentGroupInput> {
        return try {
            val snapshot = studentGroupsCollection.get().await()
            snapshot.documents.map { doc ->
                StudentGroupInput(
                    groupId = doc.getString("groupId") ?: "",
                    name = doc.getString("name") ?: "",
                    code = doc.getString("code") ?: "",
                    semester = doc.getLong("semester")?.toInt() ?: 1,
                    studentCount = doc.getLong("studentCount")?.toInt() ?: 30,
                    subjects = doc.get("subjects") as? List<String> ?: emptyList()
                )
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    private suspend fun getTimeSlots(): List<TimeSlotInput> {
        val timeSlots = mutableListOf<TimeSlotInput>()
        val days = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday")
        val hours = listOf(
            "08:00" to "09:00", "09:00" to "10:00", "10:00" to "11:00",
            "11:00" to "12:00", "12:00" to "13:00", "13:00" to "14:00",
            "14:00" to "15:00", "15:00" to "16:00", "16:00" to "17:00"
        )

        for (day in days) {
            for ((start, end) in hours) {
                timeSlots.add(
                    TimeSlotInput(
                        slotId = "${day}_${start.replace(":", "")}",
                        day = day,
                        startTime = start,
                        endTime = end,
                        duration = 60
                    )
                )
            }
        }
        return timeSlots
    }

    suspend fun getActiveTimetable(): GeneratedTimetable? {
        return try {
            val activeSnapshot = timetablesCollection
                .whereEqualTo("isActive", true)
                .limit(1)
                .get()
                .await()

            if (activeSnapshot.documents.isNotEmpty()) {
                val doc = activeSnapshot.documents.first()
                getTimetable(doc.id)
            } else null
        } catch (e: Exception) {
            null
        }
    }

    suspend fun setActiveTimetable(timetableId: String) {
        try {
            val batch = firestore.batch()

            val allTimetables = timetablesCollection.get().await()
            allTimetables.documents.forEach { doc ->
                batch.update(doc.reference, "isActive", false)
            }

            batch.update(timetablesCollection.document(timetableId), "isActive", true)
            batch.commit().await()
        } catch (e: Exception) {
            throw Exception("Failed to set active timetable: ${e.message}")
        }
    }
}
