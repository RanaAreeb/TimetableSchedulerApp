package com.example.timeatbleschedulerapp.ui.screens.coordinator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timeatbleschedulerapp.data.models.StudentGroupInput
import com.example.timeatbleschedulerapp.data.repository.TimetableRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddStudentGroupViewModel @Inject constructor(
    private val repository: TimetableRepository
) : ViewModel() {

    private val _saveSuccess = MutableLiveData<Boolean>()
    val saveSuccess: LiveData<Boolean> = _saveSuccess

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun saveStudentGroup(group: StudentGroupInput) {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                repository.saveStudentGroup(group)
                _saveSuccess.value = true
            } catch (e: Exception) {
                _errorMessage.value = e.message ?: "Failed to save student group"
            } finally {
                _isLoading.value = false
            }
        }
    }
}
