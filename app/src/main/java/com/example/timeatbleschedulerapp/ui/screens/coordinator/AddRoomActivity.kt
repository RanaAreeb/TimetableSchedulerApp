package com.example.timeatbleschedulerapp.ui.screens.coordinator

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.timeatbleschedulerapp.databinding.ActivityAddRoomBinding
import com.example.timeatbleschedulerapp.data.models.RoomInput
import com.example.timeatbleschedulerapp.data.models.RoomType
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddRoomActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddRoomBinding
    private val viewModel: AddRoomViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddRoomBinding.inflate(layoutInflater)
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
            title = "Add Room"
        }
    }

    private fun setupSpinners() {
        val roomTypes = RoomType.values().map { it.name }
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, roomTypes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerRoomType.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.saveSuccess.observe(this) { success ->
            if (success) {
                Toast.makeText(this, "Room added successfully!", Toast.LENGTH_SHORT).show()
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
            saveRoom()
        }

        binding.btnCancel.setOnClickListener {
            finish()
        }
    }

    private fun saveRoom() {
        val number = binding.etRoomNumber.text.toString().trim()
        val name = binding.etRoomName.text.toString().trim()
        val capacity = binding.etCapacity.text.toString().toIntOrNull() ?: 0
        val type = RoomType.valueOf(binding.spinnerRoomType.selectedItem.toString())
        val hasProjector = binding.cbHasProjector.isChecked
        val hasComputers = binding.cbHasComputers.isChecked
        val hasWhiteboard = binding.cbHasWhiteboard.isChecked

        if (validateInput(number, name, capacity)) {
            val room = RoomInput(
                number = number,
                name = name,
                capacity = capacity,
                type = type,
                hasProjector = hasProjector,
                hasComputers = hasComputers,
                hasWhiteboard = hasWhiteboard
            )

            viewModel.saveRoom(room)
        }
    }

    private fun validateInput(number: String, name: String, capacity: Int): Boolean {
        when {
            number.isEmpty() -> {
                binding.etRoomNumber.error = "Room number is required"
                return false
            }
            name.isEmpty() -> {
                binding.etRoomName.error = "Room name is required"
                return false
            }
            capacity <= 0 -> {
                binding.etCapacity.error = "Capacity must be greater than 0"
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
