package com.example.timeatbleschedulerapp.ui.screens.teacher

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import com.example.timeatbleschedulerapp.R
import com.example.timeatbleschedulerapp.databinding.ActivitySendNotificationBinding
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "SendNotificationActivity"

@AndroidEntryPoint
class SendNotificationActivity : ComponentActivity() {

    private lateinit var binding: ActivitySendNotificationBinding
    private val viewModel: SendNotificationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySendNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupRecipientDropdown()
        setupSendButton()
        observeViewModel()

        Log.d(TAG, "Activity created")
    }

    private fun setupToolbar() {
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    private fun setupRecipientDropdown() {
        val recipientTypes = arrayOf("All Students", "Specific Batch", "Individual Student")
        val adapter = ArrayAdapter(this, R.layout.dropdown_item, recipientTypes)
        binding.actvRecipientType.setAdapter(adapter)
        binding.actvRecipientType.setText(recipientTypes[0], false)

        binding.actvRecipientType.setOnItemClickListener { _, _, position, _ ->
            when (position) {
                0 -> { // All Students
                    binding.layoutSpecificBatch.visibility = View.GONE
                    binding.layoutIndividualStudent.visibility = View.GONE
                }
                1 -> { // Specific Batch
                    binding.layoutSpecificBatch.visibility = View.VISIBLE
                    binding.layoutIndividualStudent.visibility = View.GONE
                    loadBatches()
                }
                2 -> { // Individual Student
                    binding.layoutSpecificBatch.visibility = View.GONE
                    binding.layoutIndividualStudent.visibility = View.VISIBLE
                    loadStudents()
                }
            }
        }
    }

    private fun loadBatches() {
        // This would normally load batches from the database
        val batches = arrayOf("Batch A", "Batch B", "Batch C")
        val adapter = ArrayAdapter(this, R.layout.dropdown_item, batches)
        binding.actvBatch.setAdapter(adapter)
    }

    private fun loadStudents() {
        // This would normally load students from the database
        val students = arrayOf("Student 1", "Student 2", "Student 3")
        val adapter = ArrayAdapter(this, R.layout.dropdown_item, students)
        binding.actvStudent.setAdapter(adapter)
    }

    private fun setupSendButton() {
        binding.btnSendNotification.setOnClickListener {
            val title = binding.etNotificationTitle.text.toString().trim()
            val message = binding.etNotificationMessage.text.toString().trim()

            if (validateInput(title, message)) {
                showLoading(true)

                val recipientType = binding.actvRecipientType.text.toString()
                val recipientId = when (recipientType) {
                    "Specific Batch" -> binding.actvBatch.text.toString()
                    "Individual Student" -> binding.actvStudent.text.toString()
                    else -> "all_students"
                }

                viewModel.sendNotification(title, message, recipientType, recipientId)
            }
        }
    }

    private fun validateInput(title: String, message: String): Boolean {
        var isValid = true

        if (title.isEmpty()) {
            binding.etNotificationTitle.error = "Title is required"
            isValid = false
        }

        if (message.isEmpty()) {
            binding.etNotificationMessage.error = "Message is required"
            isValid = false
        }

        val recipientType = binding.actvRecipientType.text.toString()

        if (recipientType == "Specific Batch" && binding.actvBatch.text.toString().isEmpty()) {
            binding.actvBatch.error = "Please select a batch"
            isValid = false
        }

        if (recipientType == "Individual Student" && binding.actvStudent.text.toString().isEmpty()) {
            binding.actvStudent.error = "Please select a student"
            isValid = false
        }

        return isValid
    }

    private fun observeViewModel() {
        viewModel.notificationState.observe(this) { state ->
            when (state) {
                is NotificationState.Success -> {
                    showLoading(false)
                    Toast.makeText(this, "Notification sent successfully!", Toast.LENGTH_SHORT).show()
                    finish()
                }
                is NotificationState.Error -> {
                    showLoading(false)
                    Toast.makeText(this, state.message, Toast.LENGTH_LONG).show()
                }
                is NotificationState.Loading -> {
                    showLoading(true)
                }
                else -> {
                    showLoading(false)
                }
            }
        }
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        binding.btnSendNotification.isEnabled = !isLoading
    }
}
