package com.example.timeatbleschedulerapp.ui.screens.timetable

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.timeatbleschedulerapp.databinding.ActivityTimetableViewerBinding
import com.example.timeatbleschedulerapp.ui.screens.timetable.adapters.TimetableViewAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TimetableViewerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTimetableViewerBinding
    private val viewModel: TimetableViewModel by viewModels()
    private lateinit var timetableAdapter: TimetableViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTimetableViewerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupRecyclerView()
        setupTabLayout()
        observeViewModel()

        // Load timetable data
        viewModel.loadActiveTimetable()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "My Timetable"
    }

    private fun setupRecyclerView() {
        timetableAdapter = TimetableViewAdapter()
        binding.recyclerViewTimetable.apply {
            layoutManager = LinearLayoutManager(this@TimetableViewerActivity)
            adapter = timetableAdapter
        }
    }

    private fun setupTabLayout() {
        val days = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday")

        days.forEach { day ->
            val tab = binding.tabLayoutDays.newTab()
            tab.text = day
            binding.tabLayoutDays.addTab(tab)
        }

        binding.tabLayoutDays.addOnTabSelectedListener(object : com.google.android.material.tabs.TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: com.google.android.material.tabs.TabLayout.Tab?) {
                tab?.let {
                    val selectedDay = days[it.position]
                    viewModel.filterByDay(selectedDay)
                }
            }

            override fun onTabUnselected(tab: com.google.android.material.tabs.TabLayout.Tab?) {}
            override fun onTabReselected(tab: com.google.android.material.tabs.TabLayout.Tab?) {}
        })
    }

    private fun observeViewModel() {
        // Collect StateFlow instead of observing LiveData
        lifecycleScope.launch {
            viewModel.timetableEntries.collect { entries ->
                if (entries.isNotEmpty()) {
                    binding.recyclerViewTimetable.visibility = View.VISIBLE
                    binding.tvNoTimetable.visibility = View.GONE
                    timetableAdapter.submitList(entries)
                } else {
                    binding.recyclerViewTimetable.visibility = View.GONE
                    binding.tvNoTimetable.visibility = View.VISIBLE
                }
            }
        }

        lifecycleScope.launch {
            viewModel.isLoading.collect { isLoading ->
                binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
            }
        }

        lifecycleScope.launch {
            viewModel.errorMessage.collect { error ->
                if (error!!.isNotEmpty()) {
                    binding.tvNoTimetable.text = "Error: $error"
                    binding.tvNoTimetable.visibility = View.VISIBLE
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
