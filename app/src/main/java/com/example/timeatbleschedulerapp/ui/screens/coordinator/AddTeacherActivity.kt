package com.example.timeatbleschedulerapp.ui.screens.coordinator

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.timeatbleschedulerapp.databinding.ActivityAddTeacherBinding
import com.example.timeatbleschedulerapp.data.models.TeacherInput
import com.example.timeatbleschedulerapp.data.models.DayOfWeek
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddTeacherActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddTeacherBinding
    private val viewModel: AddTeacherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTeacherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupObservers()
        setupClickListeners()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "Add Teacher"
        }
    }

    private fun setupObservers() {
        viewModel.saveSuccess.observe(this) { success ->
            if (success) {
                Toast.makeText(this, "Teacher added successfully!", Toast.LENGTH_SHORT).show()
                finish()
            }
        }

        viewModel.errorMessage.observe(this) { error ->
            if (error.isNotEmpty()) {
                Toast.makeText(this, error, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun setupClickListeners() {
        binding.btnSave.setOnClickListener {
            saveTeacher()
        }

        binding.btnCancel.setOnClickListener {
            finish()
        }
    }

    private fun saveTeacher() {
        val name = binding.etTeacherName.text.toString().trim()
        val email = binding.etTeacherEmail.text.toString().trim()
        val phone = binding.etTeacherPhone.text.toString().trim()
        val subjects = binding.etSubjects.text.toString().split(",").map { it.trim() }
        val maxHours = binding.etMaxHours.text.toString().toIntOrNull() ?: 0

        val availableDays = mutableListOf<DayOfWeek>()
        if (binding.cbMonday.isChecked) availableDays.add(DayOfWeek.MONDAY)
        if (binding.cbTuesday.isChecked) availableDays.add(DayOfWeek.TUESDAY)
        if (binding.cbWednesday.isChecked) availableDays.add(DayOfWeek.WEDNESDAY)
        if (binding.cbThursday.isChecked) availableDays.add(DayOfWeek.THURSDAY)
        if (binding.cbFriday.isChecked) availableDays.add(DayOfWeek.FRIDAY)

        if (validateInput(name, email, subjects, maxHours, availableDays)) {
            val teacher = TeacherInput(
                name = name,
                email = email,
                phone = phone,
                subjects = subjects,
                maxHoursPerWeek = maxHours,
                availableDays = availableDays,
                preferredTimeSlots = emptyList() // Can be enhanced later
            )

            viewModel.saveTeacher(teacher)
        }
    }

    private fun validateInput(
        name: String,
        email: String,
        subjects: List<String>,
        maxHours: Int,
        availableDays: List<DayOfWeek>
    ): Boolean {
        when {
            name.isEmpty() -> {
                binding.etTeacherName.error = "Name is required"
                return false
            }
            email.isEmpty() -> {
                binding.etTeacherEmail.error = "Email is required"
                return false
            }
            subjects.isEmpty() || subjects.all { it.isEmpty() } -> {
                binding.etSubjects.error = "At least one subject is required"
                return false
            }
            maxHours <= 0 -> {
                binding.etMaxHours.error = "Max hours must be greater than 0"
                return false
            }
            availableDays.isEmpty() -> {
                Toast.makeText(this, "Please select at least one available day", Toast.LENGTH_SHORT).show()
                return false
            }
        }
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
