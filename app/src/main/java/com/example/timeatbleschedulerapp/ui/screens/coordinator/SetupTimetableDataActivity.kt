package com.example.timeatbleschedulerapp.ui.screens.coordinator

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.timeatbleschedulerapp.databinding.ActivitySetupTimetableDataBinding
import com.example.timeatbleschedulerapp.ui.screens.coordinator.adapters.TeacherInputAdapter
import com.example.timeatbleschedulerapp.ui.screens.coordinator.adapters.SubjectInputAdapter
import com.example.timeatbleschedulerapp.ui.screens.coordinator.adapters.RoomInputAdapter
import com.example.timeatbleschedulerapp.ui.screens.coordinator.adapters.StudentGroupInputAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SetupTimetableDataActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySetupTimetableDataBinding
    private val viewModel: SetupTimetableDataViewModel by viewModels()

    private lateinit var teacherAdapter: TeacherInputAdapter
    private lateinit var subjectAdapter: SubjectInputAdapter
    private lateinit var roomAdapter: RoomInputAdapter
    private lateinit var groupAdapter: StudentGroupInputAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySetupTimetableDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupRecyclerViews()
        setupObservers()
        setupClickListeners()

        // Load existing data
        viewModel.loadTimetableData()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "Setup Timetable Data"
        }
    }

    private fun setupRecyclerViews() {
        // Teachers RecyclerView
        teacherAdapter = TeacherInputAdapter(
            onEditClick = { teacher -> viewModel.editTeacher(teacher) },
            onDeleteClick = { teacher -> viewModel.deleteTeacher(teacher) }
        )
        binding.rvTeachers.apply {
            layoutManager = LinearLayoutManager(this@SetupTimetableDataActivity)
            adapter = teacherAdapter
        }

        // Subjects RecyclerView
        subjectAdapter = SubjectInputAdapter(
            onEditClick = { subject -> viewModel.editSubject(subject) },
            onDeleteClick = { subject -> viewModel.deleteSubject(subject) }
        )
        binding.rvSubjects.apply {
            layoutManager = LinearLayoutManager(this@SetupTimetableDataActivity)
            adapter = subjectAdapter
        }

        // Rooms RecyclerView
        roomAdapter = RoomInputAdapter(
            onEditClick = { room -> viewModel.editRoom(room) },
            onDeleteClick = { room -> viewModel.deleteRoom(room) }
        )
        binding.rvRooms.apply {
            layoutManager = LinearLayoutManager(this@SetupTimetableDataActivity)
            adapter = roomAdapter
        }

        // Student Groups RecyclerView
        groupAdapter = StudentGroupInputAdapter(
            onEditClick = { group -> viewModel.editStudentGroup(group) },
            onDeleteClick = { group -> viewModel.deleteStudentGroup(group) }
        )
        binding.rvStudentGroups.apply {
            layoutManager = LinearLayoutManager(this@SetupTimetableDataActivity)
            adapter = groupAdapter
        }
    }

    private fun setupObservers() {
        viewModel.teachers.observe(this) { teachers ->
            teacherAdapter.submitList(teachers)
            binding.tvTeacherCount.text = "${teachers.size} Teachers"
        }

        viewModel.subjects.observe(this) { subjects ->
            subjectAdapter.submitList(subjects)
            binding.tvSubjectCount.text = "${subjects.size} Subjects"
        }

        viewModel.rooms.observe(this) { rooms ->
            roomAdapter.submitList(rooms)
            binding.tvRoomCount.text = "${rooms.size} Rooms"
        }

        viewModel.studentGroups.observe(this) { groups ->
            groupAdapter.submitList(groups)
            binding.tvGroupCount.text = "${groups.size} Groups"
        }

        viewModel.isLoading.observe(this) { isLoading ->
            // Handle loading state
        }

        viewModel.errorMessage.observe(this) { error ->
            if (error.isNotEmpty()) {
                Toast.makeText(this, error, Toast.LENGTH_LONG).show()
            }
        }

        viewModel.saveSuccess.observe(this) { success ->
            if (success) {
                Toast.makeText(this, "Data saved successfully!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupClickListeners() {
        binding.fabAddTeacher.setOnClickListener {
            startActivity(Intent(this, AddTeacherActivity::class.java))
        }

        binding.fabAddSubject.setOnClickListener {
            startActivity(Intent(this, AddSubjectActivity::class.java))
        }

        binding.fabAddRoom.setOnClickListener {
            startActivity(Intent(this, AddRoomActivity::class.java))
        }

        binding.fabAddGroup.setOnClickListener {
            startActivity(Intent(this, AddStudentGroupActivity::class.java))
        }

        binding.btnGenerateTimetable.setOnClickListener {
            if (viewModel.validateData()) {
                val intent = Intent(this, GenerateTimetableActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please add all required data first", Toast.LENGTH_LONG).show()
            }
        }

        binding.btnSaveData.setOnClickListener {
            viewModel.saveTimetableData()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
