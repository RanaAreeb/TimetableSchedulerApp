package com.example.timeatbleschedulerapp.ui.screens.coordinator

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.timeatbleschedulerapp.databinding.ActivityGenerateTimetableBinding
import com.example.timeatbleschedulerapp.ui.screens.coordinator.adapters.TimetablePreviewAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GenerateTimetableActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGenerateTimetableBinding
    private val viewModel: GenerateTimetableViewModel by viewModels()
    private lateinit var timetableAdapter: TimetablePreviewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGenerateTimetableBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupRecyclerView()
        setupClickListeners()
        observeViewModel()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Generate Timetable"
    }

    private fun setupRecyclerView() {
        timetableAdapter = TimetablePreviewAdapter()
        binding.recyclerViewTimetable.apply {
            layoutManager = LinearLayoutManager(this@GenerateTimetableActivity)
            adapter = timetableAdapter
        }
    }

    private fun setupClickListeners() {
        binding.btnGenerateTimetable.setOnClickListener {
            showGenerationDialog()
        }

        binding.btnSaveTimetable.setOnClickListener {
            viewModel.saveTimetable()
        }

        binding.btnRegenerateTimetable.setOnClickListener {
            showRegenerationDialog()
        }
    }

    private fun observeViewModel() {
        viewModel.isGenerating.observe(this) { isGenerating ->
            binding.progressBar.visibility = if (isGenerating) View.VISIBLE else View.GONE
            binding.btnGenerateTimetable.isEnabled = !isGenerating
            binding.btnRegenerateTimetable.isEnabled = !isGenerating

            if (isGenerating) {
                binding.tvStatus.text = "Generating timetable using Genetic Algorithm..."
                binding.tvStatus.visibility = View.VISIBLE
            }
        }

        viewModel.generatedTimetable.observe(this) { timetable ->
            if (timetable != null) {
                binding.cardTimetablePreview.visibility = View.VISIBLE
                binding.tvNoTimetable.visibility = View.GONE

                // Update statistics
                binding.tvFitnessScore.text = "Conflicts: ${timetable.fitnessScore}"
                binding.tvTotalClasses.text = "Classes: ${timetable.totalClasses}"
                binding.tvGenerations.text = "Generations: ${timetable.generationsRun}"
                binding.tvImprovement.text = "Improvement: ${String.format("%.1f", timetable.improvementPercentage)}%"

                // Update status
                val statusText = when {
                    timetable.fitnessScore == 0 -> "✅ Perfect timetable generated!"
                    timetable.fitnessScore < 5 -> "🎯 Excellent timetable with minimal conflicts"
                    timetable.fitnessScore < 15 -> "👍 Good timetable generated"
                    else -> "⚠️ Timetable generated with some conflicts"
                }
                binding.tvStatus.text = statusText

                // Show timetable entries
                timetableAdapter.submitList(timetable.entries)

                binding.btnSaveTimetable.visibility = View.VISIBLE
                binding.btnRegenerateTimetable.visibility = View.VISIBLE
            } else {
                binding.cardTimetablePreview.visibility = View.GONE
                binding.tvNoTimetable.visibility = View.VISIBLE
                binding.btnSaveTimetable.visibility = View.GONE
                binding.btnRegenerateTimetable.visibility = View.GONE
            }
        }

        viewModel.errorMessage.observe(this) { error ->
            if (error.isNotEmpty()) {
                Toast.makeText(this, error, Toast.LENGTH_LONG).show()
                binding.tvStatus.text = "❌ Generation failed: $error"
            }
        }

        viewModel.saveSuccess.observe(this) { success ->
            if (success) {
                Toast.makeText(this, "✅ Timetable saved successfully!", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }

    private fun showGenerationDialog() {
        androidx.appcompat.app.AlertDialog.Builder(this)
            .setTitle("Generate Timetable")
            .setMessage("This will generate a new timetable for University of Computer Science using Genetic Algorithm. This may take a few minutes.")
            .setPositiveButton("Generate") { _, _ ->
                viewModel.generateTimetable()
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun showRegenerationDialog() {
        androidx.appcompat.app.AlertDialog.Builder(this)
            .setTitle("Regenerate Timetable")
            .setMessage("This will create a new timetable and replace the current one. Continue?")
            .setPositiveButton("Regenerate") { _, _ ->
                viewModel.generateTimetable()
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
