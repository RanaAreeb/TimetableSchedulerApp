package com.example.timeatbleschedulerapp.ui.screens.timetable

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timeatbleschedulerapp.data.models.TimetableEntry
import com.example.timeatbleschedulerapp.data.models.User
import com.example.timeatbleschedulerapp.data.models.UserRole
import com.example.timeatbleschedulerapp.data.repository.AuthRepository
import com.example.timeatbleschedulerapp.data.repository.TimetableRepository
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TimetableViewModel @Inject constructor(
    private val timetableRepository: TimetableRepository,
    private val authRepository: AuthRepository,
    private val firestore: FirebaseFirestore
) : ViewModel() {

    private val _timetableEntries = MutableStateFlow<List<TimetableEntry>>(emptyList())
    val timetableEntries: StateFlow<List<TimetableEntry>> = _timetableEntries.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage.asStateFlow()

    private val _selectedDay = MutableStateFlow("Monday")
    val selectedDay: StateFlow<String> = _selectedDay.asStateFlow()

    private var currentUser: User? = null

    init {
        loadCurrentUser()
    }

    private fun loadCurrentUser() {
        viewModelScope.launch {
            try {
                currentUser = authRepository.getCurrentUser()
                loadActiveTimetable()
            } catch (e: Exception) {
                _errorMessage.value = "Failed to load user data: ${e.message}"
            }
        }
    }

    fun loadActiveTimetable() {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null

            try {
                val user = currentUser
                if (user != null) {
                    val entries = when (user.role) {
                        UserRole.STUDENT -> {
                            // Load timetable for student's batch
                            if (user.batchId.isNotEmpty()) {
                                timetableRepository.getTimetableForBatch(user.batchId)
                            } else {
                                emptyList()
                            }
                        }
                        UserRole.TEACHER -> {
                            // Load timetable for teacher's classes
                            timetableRepository.getTimetableForTeacher(user.id)
                        }
                        UserRole.BATCH_COORDINATOR -> {
                            // Load all timetables for coordinator
                            timetableRepository.getAllTimetables()
                        }
                    }
                    _timetableEntries.value = entries
                } else {
                    _errorMessage.value = "User not found"
                }
            } catch (e: Exception) {
                _errorMessage.value = "Failed to load timetable: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun filterByDay(day: String): List<TimetableEntry> {
        return _timetableEntries.value.filter { entry ->
            entry.dayOfWeek.equals(day, ignoreCase = true)
        }.sortedBy { it.startTime }
    }

    fun selectDay(day: String) {
        _selectedDay.value = day
    }

    fun getEntriesForSelectedDay(): List<TimetableEntry> {
        return filterByDay(_selectedDay.value)
    }

    fun getEntriesForDay(day: String): List<TimetableEntry> {
        return filterByDay(day)
    }

    fun refreshTimetable() {
        loadActiveTimetable()
    }

    fun clearError() {
        _errorMessage.value = null
    }

    // Additional utility methods for timetable management
    fun getTimetableForWeek(): Map<String, List<TimetableEntry>> {
        val daysOfWeek = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
        return daysOfWeek.associateWith { day ->
            filterByDay(day)
        }
    }

    fun hasClassesOnDay(day: String): Boolean {
        return filterByDay(day).isNotEmpty()
    }

    fun getTotalClassesForWeek(): Int {
        return _timetableEntries.value.size
    }

    fun getNextClass(): TimetableEntry? {
        val currentTime = System.currentTimeMillis()
        return _timetableEntries.value
            .filter { entry ->
                // Simple time comparison - in real app you'd parse the time properly
                entry.startTime.isNotEmpty()
            }
            .minByOrNull { it.startTime }
    }
}
