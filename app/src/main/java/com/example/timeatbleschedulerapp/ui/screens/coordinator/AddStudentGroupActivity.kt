package com.example.timeatbleschedulerapp.ui.screens.coordinator

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.timeatbleschedulerapp.databinding.ActivityAddStudentGroupBinding
import com.example.timeatbleschedulerapp.data.models.StudentGroupInput
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddStudentGroupActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddStudentGroupBinding
    private val viewModel: AddStudentGroupViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddStudentGroupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupObservers()
        setupClickListeners()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "Add Student Group"
        }
    }

    private fun setupObservers() {
        viewModel.saveSuccess.observe(this) { success ->
            if (success) {
                Toast.makeText(this, "Student group added successfully!", Toast.LENGTH_SHORT).show()
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
            saveStudentGroup()
        }

        binding.btnCancel.setOnClickListener {
            finish()
        }
    }

    private fun saveStudentGroup() {
        val name = binding.etGroupName.text.toString().trim()
        val code = binding.etGroupCode.text.toString().trim()
        val semester = binding.etSemester.text.toString().toIntOrNull() ?: 0
        val studentCount = binding.etStudentCount.text.toString().toIntOrNull() ?: 0
        val subjects = binding.etSubjects.text.toString().split(",").map { it.trim() }.filter { it.isNotEmpty() }

        if (validateInput(name, code, semester, studentCount, subjects)) {
            val group = StudentGroupInput(
                name = name,
                code = code,
                semester = semester,
                studentCount = studentCount,
                subjects = subjects
            )

            viewModel.saveStudentGroup(group)
        }
    }

    private fun validateInput(
        name: String,
        code: String,
        semester: Int,
        studentCount: Int,
        subjects: List<String>
    ): Boolean {
        when {
            name.isEmpty() -> {
                binding.etGroupName.error = "Group name is required"
                return false
            }
            code.isEmpty() -> {
                binding.etGroupCode.error = "Group code is required"
                return false
            }
            semester <= 0 -> {
                binding.etSemester.error = "Semester must be greater than 0"
                return false
            }
            studentCount <= 0 -> {
                binding.etStudentCount.error = "Student count must be greater than 0"
                return false
            }
            subjects.isEmpty() -> {
                binding.etSubjects.error = "At least one subject is required"
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
