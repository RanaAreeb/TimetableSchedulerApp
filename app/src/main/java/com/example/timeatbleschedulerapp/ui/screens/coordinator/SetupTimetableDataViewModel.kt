package com.example.timeatbleschedulerapp.ui.screens.coordinator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timeatbleschedulerapp.data.models.*
import com.example.timeatbleschedulerapp.data.repository.TimetableRepository
import com.example.timeatbleschedulerapp.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SetupTimetableDataViewModel @Inject constructor(
    private val timetableRepository: TimetableRepository,
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _teachers = MutableLiveData<List<TeacherInput>>()
    val teachers: LiveData<List<TeacherInput>> = _teachers

    private val _subjects = MutableLiveData<List<SubjectInput>>()
    val subjects: LiveData<List<SubjectInput>> = _subjects

    private val _rooms = MutableLiveData<List<RoomInput>>()
    val rooms: LiveData<List<RoomInput>> = _rooms

    private val _studentGroups = MutableLiveData<List<StudentGroupInput>>()
    val studentGroups: LiveData<List<StudentGroupInput>> = _studentGroups

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    private val _saveSuccess = MutableLiveData<Boolean>()
    val saveSuccess: LiveData<Boolean> = _saveSuccess

    private var currentTimetableData: TimetableInputData? = null

    fun loadTimetableData() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                _errorMessage.value = ""

                val data = timetableRepository.getTimetableInputData()
                if (data != null) {
                    currentTimetableData = data
                    _teachers.value = data.teachers
                    _subjects.value = data.subjects
                    _rooms.value = data.rooms
                    _studentGroups.value = data.studentGroups
                } else {
                    // Initialize with empty lists
                    _teachers.value = emptyList()
                    _subjects.value = emptyList()
                    _rooms.value = emptyList()
                    _studentGroups.value = emptyList()
                }

            } catch (e: Exception) {
                _errorMessage.value = "Failed to load data: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun addTeacher(teacher: TeacherInput) {
        val currentList = _teachers.value?.toMutableList() ?: mutableListOf()
        currentList.add(teacher)
        _teachers.value = currentList
    }

    fun editTeacher(teacher: TeacherInput) {
        val currentList = _teachers.value?.toMutableList() ?: mutableListOf()
        val index = currentList.indexOfFirst { it.teacherId == teacher.teacherId }
        if (index != -1) {
            currentList[index] = teacher
            _teachers.value = currentList
        }
    }

    fun deleteTeacher(teacher: TeacherInput) {
        val currentList = _teachers.value?.toMutableList() ?: mutableListOf()
        currentList.removeAll { it.teacherId == teacher.teacherId }
        _teachers.value = currentList
    }

    fun addSubject(subject: SubjectInput) {
        val currentList = _subjects.value?.toMutableList() ?: mutableListOf()
        currentList.add(subject)
        _subjects.value = currentList
    }

    fun editSubject(subject: SubjectInput) {
        val currentList = _subjects.value?.toMutableList() ?: mutableListOf()
        val index = currentList.indexOfFirst { it.subjectId == subject.subjectId }
        if (index != -1) {
            currentList[index] = subject
            _subjects.value = currentList
        }
    }

    fun deleteSubject(subject: SubjectInput) {
        val currentList = _subjects.value?.toMutableList() ?: mutableListOf()
        currentList.removeAll { it.subjectId == subject.subjectId }
        _subjects.value = currentList
    }

    fun addRoom(room: RoomInput) {
        val currentList = _rooms.value?.toMutableList() ?: mutableListOf()
        currentList.add(room)
        _rooms.value = currentList
    }

    fun editRoom(room: RoomInput) {
        val currentList = _rooms.value?.toMutableList() ?: mutableListOf()
        val index = currentList.indexOfFirst { it.roomId == room.roomId }
        if (index != -1) {
            currentList[index] = room
            _rooms.value = currentList
        }
    }

    fun deleteRoom(room: RoomInput) {
        val currentList = _rooms.value?.toMutableList() ?: mutableListOf()
        currentList.removeAll { it.roomId == room.roomId }
        _rooms.value = currentList
    }

    fun addStudentGroup(group: StudentGroupInput) {
        val currentList = _studentGroups.value?.toMutableList() ?: mutableListOf()
        currentList.add(group)
        _studentGroups.value = currentList
    }

    fun editStudentGroup(group: StudentGroupInput) {
        val currentList = _studentGroups.value?.toMutableList() ?: mutableListOf()
        val index = currentList.indexOfFirst { it.groupId == group.groupId }
        if (index != -1) {
            currentList[index] = group
            _studentGroups.value = currentList
        }
    }

    fun deleteStudentGroup(group: StudentGroupInput) {
        val currentList = _studentGroups.value?.toMutableList() ?: mutableListOf()
        currentList.removeAll { it.groupId == group.groupId }
        _studentGroups.value = currentList
    }

    fun validateData(): Boolean {
        val teachers = _teachers.value ?: emptyList()
        val subjects = _subjects.value ?: emptyList()
        val rooms = _rooms.value ?: emptyList()
        val groups = _studentGroups.value ?: emptyList()

        return teachers.isNotEmpty() && subjects.isNotEmpty() &&
                rooms.isNotEmpty() && groups.isNotEmpty()
    }

    fun saveTimetableData() {
        viewModelScope.launch {
            try {
                _isLoading.value = true

                val currentUser = authRepository.getCurrentUser()
                val timetableData = TimetableInputData(
                    dataId = currentTimetableData?.dataId ?: "data_${System.currentTimeMillis()}",
                    teachers = _teachers.value ?: emptyList(),
                    subjects = _subjects.value ?: emptyList(),
                    rooms = _rooms.value ?: emptyList(),
                    studentGroups = _studentGroups.value ?: emptyList(),
                    timeSlots = generateDefaultTimeSlots(),
                    constraints = TimetableConstraints(),
                    createdBy = currentUser?.id ?: "",
                    createdAt = System.currentTimeMillis()
                )

                timetableRepository.saveTimetableInputData(timetableData)
                _saveSuccess.value = true

            } catch (e: Exception) {
                _errorMessage.value = "Failed to save data: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    private fun generateDefaultTimeSlots(): List<TimeSlotInput> {
        val timeSlots = mutableListOf<TimeSlotInput>()
        val days = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday")
        val hours = listOf(
            "08:00" to "09:00",
            "09:00" to "10:00",
            "10:00" to "11:00",
            "11:00" to "12:00",
            "12:00" to "13:00",
            "13:00" to "14:00",
            "14:00" to "15:00",
            "15:00" to "16:00",
            "16:00" to "17:00"
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

    fun getTimetableInputData(): TimetableInputData? {
        return if (validateData()) {
            TimetableInputData(
                teachers = _teachers.value ?: emptyList(),
                subjects = _subjects.value ?: emptyList(),
                rooms = _rooms.value ?: emptyList(),
                studentGroups = _studentGroups.value ?: emptyList(),
                timeSlots = generateDefaultTimeSlots(),
                constraints = TimetableConstraints()
            )
        } else null
    }
}
