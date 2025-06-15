package com.example.timeatbleschedulerapp.ui.screens.notifications

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.timeatbleschedulerapp.R
import com.example.timeatbleschedulerapp.databinding.ActivityNotificationsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationsActivity : ComponentActivity() {

    private lateinit var binding: ActivityNotificationsBinding
    private val viewModel: NotificationsViewModel by viewModels()
    private lateinit var adapter: NotificationsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotificationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupRecyclerView()
        observeViewModel()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_notifications, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_refresh -> {
                viewModel.refreshNotifications()
                true
            }
            R.id.action_debug -> {
                viewModel.debugNotifications()
                Toast.makeText(this, "Debug info logged - check Logcat", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setupToolbar() {
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    private fun setupRecyclerView() {
        adapter = NotificationsAdapter { notification ->
            viewModel.markAsRead(notification)
        }

        binding.rvNotifications.apply {
            layoutManager = LinearLayoutManager(this@NotificationsActivity)
            adapter = this@NotificationsActivity.adapter
        }
    }

    private fun observeViewModel() {
        viewModel.notifications.observe(this) { notifications ->
            if (notifications.isEmpty()) {
                showEmptyState()
            } else {
                showNotifications(notifications)
            }
        }

        viewModel.isLoading.observe(this) { isLoading ->
            // You can add a progress bar here if needed
            if (isLoading) {
                // Show loading indicator
            }
        }

        viewModel.error.observe(this) { error ->
            if (error != null) {
                Toast.makeText(this, "Error: $error", Toast.LENGTH_LONG).show()
                showEmptyState()
            }
        }
    }

    private fun showNotifications(notifications: List<com.example.timeatbleschedulerapp.data.models.Notification>) {
        binding.rvNotifications.visibility = View.VISIBLE
        binding.layoutEmptyState.visibility = View.GONE
        adapter.submitList(notifications)
    }

    private fun showEmptyState() {
        binding.rvNotifications.visibility = View.GONE
        binding.layoutEmptyState.visibility = View.VISIBLE
    }
}
