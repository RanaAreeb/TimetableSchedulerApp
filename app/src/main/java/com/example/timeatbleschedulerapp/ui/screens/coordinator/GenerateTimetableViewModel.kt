package com.example.timeatbleschedulerapp.ui.screens.coordinator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timeatbleschedulerapp.data.models.GeneratedTimetable
import com.example.timeatbleschedulerapp.data.models.TimetableEntry
import com.example.timeatbleschedulerapp.data.repository.TimetableRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import javax.inject.Inject

@HiltViewModel
class GenerateTimetableViewModel @Inject constructor(
    private val timetableRepository: TimetableRepository
) : ViewModel() {

    private val _isGenerating = MutableLiveData<Boolean>()
    val isGenerating: LiveData<Boolean> = _isGenerating

    private val _generatedTimetable = MutableLiveData<GeneratedTimetable?>()
    val generatedTimetable: LiveData<GeneratedTimetable?> = _generatedTimetable

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    private val _saveSuccess = MutableLiveData<Boolean>()
    val saveSuccess: LiveData<Boolean> = _saveSuccess

    fun generateTimetable() {
        viewModelScope.launch {
            try {
                _isGenerating.value = true
                _errorMessage.value = ""

                val result = withContext(Dispatchers.IO) {
                    runGeneticAlgorithm()
                }

                if (result != null) {
                    _generatedTimetable.value = result
                } else {
                    _errorMessage.value = "Failed to generate timetable"
                }

            } catch (e: Exception) {
                _errorMessage.value = "Error: ${e.message}"
            } finally {
                _isGenerating.value = false
            }
        }
    }

    private suspend fun runGeneticAlgorithm(): GeneratedTimetable? {
        return try {
            // Create Python script content
            val pythonScript = """
import sys
import json
import random
from datetime import datetime

# [The genetic algorithm code would be embedded here]
# For demo purposes, we'll simulate the algorithm result

def simulate_genetic_algorithm():
    # Simulate algorithm execution
    import time
    time.sleep(2)  # Simulate processing time
    
    # Generate sample timetable data
    sample_entries = [
        {
            "id": "entry_1",
            "groupId": "CS-1A",
            "subjectId": "CS101",
            "subjectName": "Programming Fundamentals",
            "teacherId": "T001",
            "teacherName": "Dr. Ahmed Khan",
            "roomId": "R101",
            "day": "Monday",
            "startTime": "09:00",
            "endTime": "10:00",
            "type": "lecture",
            "students": 45
        },
        {
            "id": "entry_2",
            "groupId": "CS-1A",
            "subjectId": "MATH101",
            "subjectName": "Calculus I",
            "teacherId": "T005",
            "teacherName": "Dr. Omar Farooq",
            "roomId": "R102",
            "day": "Monday",
            "startTime": "10:00",
            "endTime": "11:00",
            "type": "lecture",
            "students": 45
        },
        {
            "id": "entry_3",
            "groupId": "CS-1A",
            "subjectId": "CS101",
            "subjectName": "Programming Fundamentals Lab",
            "teacherId": "T001",
            "teacherName": "Dr. Ahmed Khan",
            "roomId": "LAB1",
            "day": "Tuesday",
            "startTime": "14:00",
            "endTime": "16:00",
            "type": "lab",
            "students": 45
        }
    ]
    
    result = {
        "success": True,
        "fitness_score": 2,
        "total_classes": len(sample_entries),
        "generations_run": 150,
        "statistics": {
            "improvement_percentage": 85.5
        },
        "entries": sample_entries
    }
    
    return result

# Run simulation
result = simulate_genetic_algorithm()
print(json.dumps(result))
            """.trimIndent()

            // Execute Python script (simulated)
            val result = simulateGeneticAlgorithmExecution()

            // Parse result and create GeneratedTimetable
            parseGeneticAlgorithmResult(result)

        } catch (e: Exception) {
            null
        }
    }

    private fun simulateGeneticAlgorithmExecution(): String {
        // Simulate the genetic algorithm execution
        // In a real implementation, this would execute the Python script
        return """
        {
            "success": true,
            "fitness_score": 3,
            "total_classes": 24,
            "generations_run": 180,
            "statistics": {
                "improvement_percentage": 92.1
            },
            "entries": [
                {
                    "id": "entry_1",
                    "groupId": "CS-1A",
                    "subjectId": "CS101",
                    "subjectName": "Programming Fundamentals",
                    "teacherId": "T001",
                    "teacherName": "Dr. Ahmed Khan",
                    "roomId": "R101",
                    "day": "Monday",
                    "startTime": "09:00",
                    "endTime": "10:00",
                    "type": "lecture",
                    "students": 45
                },
                {
                    "id": "entry_2",
                    "groupId": "CS-1A",
                    "subjectId": "MATH101",
                    "subjectName": "Calculus I",
                    "teacherId": "T005",
                    "teacherName": "Dr. Omar Farooq",
                    "roomId": "R102",
                    "day": "Monday",
                    "startTime": "10:00",
                    "endTime": "11:00",
                    "type": "lecture",
                    "students": 45
                },
                {
                    "id": "entry_3",
                    "groupId": "CS-3A",
                    "subjectId": "CS201",
                    "subjectName": "Object Oriented Programming",
                    "teacherId": "T001",
                    "teacherName": "Dr. Ahmed Khan",
                    "roomId": "R103",
                    "day": "Tuesday",
                    "startTime": "11:00",
                    "endTime": "12:00",
                    "type": "lecture",
                    "students": 38
                },
                {
                    "id": "entry_4",
                    "groupId": "CS-3A",
                    "subjectId": "CS202",
                    "subjectName": "Database Systems",
                    "teacherId": "T002",
                    "teacherName": "Dr. Sarah Ali",
                    "roomId": "LAB2",
                    "day": "Wednesday",
                    "startTime": "14:00",
                    "endTime": "16:00",
                    "type": "lab",
                    "students": 38
                }
            ]
        }
        """.trimIndent()
    }

    private fun parseGeneticAlgorithmResult(jsonResult: String): GeneratedTimetable {
        val json = JSONObject(jsonResult)
        val entriesArray = json.getJSONArray("entries")
        val entries = mutableListOf<TimetableEntry>()

        for (i in 0 until entriesArray.length()) {
            val entryJson = entriesArray.getJSONObject(i)
            entries.add(
                TimetableEntry(
                    id = entryJson.getString("id"),
                    groupId = entryJson.getString("groupId"),
                    subjectId = entryJson.getString("subjectId"),
                    subjectName = entryJson.getString("subjectName"),
                    teacherId = entryJson.getString("teacherId"),
                    teacherName = entryJson.getString("teacherName"),
                    roomId = entryJson.getString("roomId"),
                    day = entryJson.getString("day"),
                    startTime = entryJson.getString("startTime"),
                    endTime = entryJson.getString("endTime"),
                    type = entryJson.getString("type"),
                    students = entryJson.getInt("students")
                )
            )
        }

        return GeneratedTimetable(
            id = "timetable_${System.currentTimeMillis()}",
            fitnessScore = json.getInt("fitness_score"),
            totalClasses = json.getInt("total_classes"),
            generationsRun = json.getInt("generations_run"),
            improvementPercentage = json.getJSONObject("statistics").getDouble("improvement_percentage"),
            entries = entries
        )
    }

    fun saveTimetable() {
        viewModelScope.launch {
            try {
                val timetable = _generatedTimetable.value
                if (timetable != null) {
                    timetableRepository.saveTimetable(timetable)
                    _saveSuccess.value = true
                }
            } catch (e: Exception) {
                _errorMessage.value = "Failed to save timetable: ${e.message}"
            }
        }
    }
}
