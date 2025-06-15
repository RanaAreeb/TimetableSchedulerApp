package com.example.timeatbleschedulerapp.ui.screens.auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.lifecycleScope
import com.example.timeatbleschedulerapp.data.models.UserRole
import com.example.timeatbleschedulerapp.databinding.ActivityAuthBinding
import com.example.timeatbleschedulerapp.ui.screens.coordinator.CoordinatorDashboardActivity
import com.example.timeatbleschedulerapp.ui.screens.student.StudentDashboardActivity
import com.example.timeatbleschedulerapp.ui.screens.teacher.TeacherDashboardActivity
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

private const val TAG = "AuthActivity"

@AndroidEntryPoint
class AuthActivity : FragmentActivity() {

    private lateinit var binding: ActivityAuthBinding
    private val viewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            binding = ActivityAuthBinding.inflate(layoutInflater)
            setContentView(binding.root)

            setupViewPager()
            observeAuthState()

            Log.d(TAG, "AuthActivity created")
        } catch (e: Exception) {
            Log.e(TAG, "Error in onCreate", e)
            Toast.makeText(this, "Error loading auth screen: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }

    private fun setupViewPager() {
        val adapter = AuthPagerAdapter(this)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Sign In"
                1 -> "Sign Up"
                else -> ""
            }
        }.attach()

        Log.d(TAG, "ViewPager setup complete")
    }

    private fun observeAuthState() {
        lifecycleScope.launch {
            viewModel.authState.collect { state ->
                Log.d(TAG, "Auth state changed: $state")
                when (state) {
                    is AuthState.Loading -> {
                        // Loading state is handled in fragments
                    }
                    is AuthState.Success -> {
                        Log.d(TAG, "Authentication successful, navigating to dashboard")
                        navigateToDashboard(state.user.role)
                    }
                    is AuthState.Error -> {
                        Log.e(TAG, "Authentication error: ${state.message}")
                        Toast.makeText(this@AuthActivity, state.message, Toast.LENGTH_LONG).show()
                    }
                    is AuthState.Idle -> {
                        // Do nothing
                    }
                }
            }
        }
    }

    private fun navigateToDashboard(role: UserRole) {
        Log.d(TAG, "Navigating to dashboard for role: $role")
        val intent = when (role) {
            UserRole.STUDENT -> Intent(this, StudentDashboardActivity::class.java)
            UserRole.TEACHER -> Intent(this, TeacherDashboardActivity::class.java)
            UserRole.BATCH_COORDINATOR -> Intent(this, CoordinatorDashboardActivity::class.java)
        }
        startActivity(intent)
        finish()
    }
}
