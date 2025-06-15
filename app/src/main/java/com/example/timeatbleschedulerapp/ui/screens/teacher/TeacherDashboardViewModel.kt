package com.example.timeatbleschedulerapp.ui.screens.teacher

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timeatbleschedulerapp.data.models.User
import com.example.timeatbleschedulerapp.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeacherDashboardViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _currentUser = MutableLiveData<User?>()
    val currentUser: LiveData<User?> = _currentUser

    init {
        loadCurrentUser()
    }

    private fun loadCurrentUser() {
        viewModelScope.launch {
            val user = authRepository.getCurrentUser()
            _currentUser.value = user
        }
    }

    fun logout() {
        authRepository.signOut()
    }
}
