package com.example.timeatbleschedulerapp.ui.screens.student

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import com.example.timeatbleschedulerapp.R
import com.example.timeatbleschedulerapp.databinding.ActivityDashboardStudentBinding
import com.example.timeatbleschedulerapp.ui.screens.auth.AuthActivity
import com.example.timeatbleschedulerapp.ui.screens.notifications.NotificationsActivity
import com.example.timeatbleschedulerapp.ui.screens.timetable.TimetableViewerActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StudentDashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardStudentBinding
    private val viewModel: StudentDashboardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupClickListeners()
        observeData()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_dashboard, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_logout -> {
                showLogoutDialog()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
    }

    private fun setupClickListeners() {
        binding.cardViewTimetable.setOnClickListener {
            startActivity(Intent(this, TimetableViewerActivity::class.java))
        }

        binding.cardNotifications.setOnClickListener {
            startActivity(Intent(this, NotificationsActivity::class.java))
        }

        binding.cardContactTeacher.setOnClickListener {
            startActivity(Intent(this, ContactTeacherActivity::class.java))
        }
    }

    private fun observeData() {
        // Observe ViewModel data and update UI
        viewModel.currentUser.observe(this) { user ->
            user?.let {
                binding.tvStudentName.text = it.name
            }
        }
    }

    private fun showLogoutDialog() {
        AlertDialog.Builder(this)
            .setTitle("Logout")
            .setMessage("Are you sure you want to logout?")
            .setPositiveButton("Logout") { _, _ ->
                logout()
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun logout() {
        viewModel.logout()
        Toast.makeText(this, "Logged out successfully", Toast.LENGTH_SHORT).show()

        val intent = Intent(this, AuthActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
}
