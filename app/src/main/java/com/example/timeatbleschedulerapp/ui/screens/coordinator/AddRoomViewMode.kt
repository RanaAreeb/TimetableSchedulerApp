package com.example.timeatbleschedulerapp.ui.screens.coordinator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timeatbleschedulerapp.data.models.RoomInput
import com.example.timeatbleschedulerapp.data.repository.TimetableRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddRoomViewModel @Inject constructor(
    private val repository: TimetableRepository
) : ViewModel() {

    private val _saveSuccess = MutableLiveData<Boolean>()
    val saveSuccess: LiveData<Boolean> = _saveSuccess

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun saveRoom(room: RoomInput) {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                repository.saveRoom(room)
                _saveSuccess.value = true
            } catch (e: Exception) {
                _errorMessage.value = e.message ?: "Failed to save room"
            } finally {
                _isLoading.value = false
            }
        }
    }
}
