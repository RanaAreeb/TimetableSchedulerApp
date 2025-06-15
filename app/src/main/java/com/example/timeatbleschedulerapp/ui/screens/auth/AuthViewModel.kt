package com.example.timeatbleschedulerapp.ui.screens.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timeatbleschedulerapp.data.models.User
import com.example.timeatbleschedulerapp.data.models.UserRole
import com.example.timeatbleschedulerapp.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "AuthViewModel"

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _authState = MutableStateFlow<AuthState>(AuthState.Idle)
    val authState: StateFlow<AuthState> = _authState

    fun signIn(email: String, password: String) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading

            try {
                Log.d(TAG, "Starting sign in process for $email")
                val result = authRepository.signIn(email, password)

                if (result.isSuccess) {
                    val user = result.getOrThrow()
                    Log.d(TAG, "Sign in successful for ${user.email}")
                    _authState.value = AuthState.Success(user)
                } else {
                    val error = result.exceptionOrNull()
                    Log.e(TAG, "Sign in failed", error)
                    _authState.value = AuthState.Error(error?.message ?: "Sign in failed")
                }
            } catch (e: Exception) {
                Log.e(TAG, "Exception during sign in", e)
                _authState.value = AuthState.Error(e.message ?: "Sign in failed")
            }
        }
    }

    fun signUp(email: String, password: String, name: String, role: UserRole) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading

            try {
                Log.d(TAG, "Starting sign up process for $email with role $role")
                val result = authRepository.signUp(email, password, name, role)

                if (result.isSuccess) {
                    val user = result.getOrThrow()
                    Log.d(TAG, "Sign up successful for ${user.email}")
                    _authState.value = AuthState.Success(user)
                } else {
                    val error = result.exceptionOrNull()
                    Log.e(TAG, "Sign up failed", error)
                    _authState.value = AuthState.Error(error?.message ?: "Sign up failed")
                }
            } catch (e: Exception) {
                Log.e(TAG, "Exception during sign up", e)
                _authState.value = AuthState.Error(e.message ?: "Sign up failed")
            }
        }
    }

    fun resetAuthState() {
        _authState.value = AuthState.Idle
    }
}

sealed class AuthState {
    object Idle : AuthState()
    object Loading : AuthState()
    data class Success(val user: User) : AuthState()
    data class Error(val message: String) : AuthState()

    override fun toString(): String {
        return when (this) {
            is Idle -> "Idle"
            is Loading -> "Loading"
            is Success -> "Success(${user.email})"
            is Error -> "Error($message)"
        }
    }
}
