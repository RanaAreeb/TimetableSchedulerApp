package com.example.timeatbleschedulerapp.ui.screens.coordinator

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.timeatbleschedulerapp.databinding.ActivityAddSubjectBinding
import com.example.timeatbleschedulerapp.data.models.SubjectInput
import com.example.timeatbleschedulerapp.data.models.SubjectType
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddSubjectActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddSubjectBinding
    private val viewModel: AddSubjectViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddSubjectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupSpinners()
        setupObservers()
        setupClickListeners()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "Add Subject"
        }
    }

    private fun setupSpinners() {
        val subjectTypes = SubjectType.values().map { it.name }
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, subjectTypes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerSubjectType.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.saveSuccess.observe(this) { success ->
            if (success) {
                Toast.makeText(this, "Subject added successfully!", Toast.LENGTH_SHORT).show()
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
            saveSubject()
        }

        binding.btnCancel.setOnClickListener {
            finish()
        }
    }

    private fun saveSubject() {
        val name = binding.etSubjectName.text.toString().trim()
        val code = binding.etSubjectCode.text.toString().trim()
        val hoursPerWeek = binding.etHoursPerWeek.text.toString().toIntOrNull() ?: 0
        val type = SubjectType.valueOf(binding.spinnerSubjectType.selectedItem.toString())
        val requiresLab = binding.cbRequiresLab.isChecked
        val requiresProjector = binding.cbRequiresProjector.isChecked

        if (validateInput(name, code, hoursPerWeek)) {
            val subject = SubjectInput(
                name = name,
                code = code,
                hoursPerWeek = hoursPerWeek,
                type = type,
                requiresLab = requiresLab,
                requiresProjector = requiresProjector
            )

            viewModel.saveSubject(subject)
        }
    }

    private fun validateInput(name: String, code: String, hoursPerWeek: Int): Boolean {
        when {
            name.isEmpty() -> {
                binding.etSubjectName.error = "Subject name is required"
                return false
            }
            code.isEmpty() -> {
                binding.etSubjectCode.error = "Subject code is required"
                return false
            }
            hoursPerWeek <= 0 -> {
                binding.etHoursPerWeek.error = "Hours per week must be greater than 0"
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
