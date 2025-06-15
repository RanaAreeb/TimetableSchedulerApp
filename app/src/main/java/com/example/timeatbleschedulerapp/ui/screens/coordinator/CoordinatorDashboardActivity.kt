package com.example.timeatbleschedulerapp.ui.screens.coordinator

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AlertDialog
import androidx.activity.viewModels
import com.example.timeatbleschedulerapp.R
import com.example.timeatbleschedulerapp.databinding.ActivityDashboardCoordinatorBinding
import com.example.timeatbleschedulerapp.ui.screens.auth.AuthActivity
import com.example.timeatbleschedulerapp.ui.screens.notifications.NotificationsActivity
import com.example.timeatbleschedulerapp.ui.screens.timetable.TimetableViewerActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoordinatorDashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardCoordinatorBinding
    private val viewModel: CoordinatorDashboardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardCoordinatorBinding.inflate(layoutInflater)
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
        binding.cardGenerateTimetable.setOnClickListener {
            startActivity(Intent(this, GenerateTimetableActivity::class.java))
        }

        binding.cardAssignTimetable.setOnClickListener {
            startActivity(Intent(this, AssignTimetableActivity::class.java))
        }

        binding.cardManageNotifications.setOnClickListener {
            startActivity(Intent(this, NotificationsActivity::class.java))
        }

        binding.cardViewReports.setOnClickListener {
            startActivity(Intent(this, ReportsActivity::class.java))
        }

        binding.fabQuickAction.setOnClickListener {
            // Show quick action menu
        }
    }

    private fun observeData() {
        // Observe ViewModel data and update UI
        viewModel.currentUser.observe(this) { user ->
            user?.let {
                binding.tvUserName.text = it.name
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
