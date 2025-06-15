package com.example.timeatbleschedulerapp.ui.screens.coordinator.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.timeatbleschedulerapp.databinding.ItemTeacherInputBinding
import com.example.timeatbleschedulerapp.data.models.TeacherInput

class TeacherInputAdapter(
    private val onEditClick: (TeacherInput) -> Unit,
    private val onDeleteClick: (TeacherInput) -> Unit
) : ListAdapter<TeacherInput, TeacherInputAdapter.TeacherViewHolder>(TeacherDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeacherViewHolder {
        val binding = ItemTeacherInputBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return TeacherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TeacherViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class TeacherViewHolder(
        private val binding: ItemTeacherInputBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(teacher: TeacherInput) {
            binding.apply {
                tvTeacherName.text = teacher.name
                tvTeacherEmail.text = teacher.email
                tvSubjects.text = "Subjects: ${teacher.subjects.joinToString(", ")}"
                tvMaxHours.text = "Max Hours: ${teacher.maxHoursPerWeek}/week"
                tvAvailability.text = "Available: ${teacher.availableDays.size} days"

                btnEdit.setOnClickListener { onEditClick(teacher) }
                btnDelete.setOnClickListener { onDeleteClick(teacher) }
            }
        }
    }

    private class TeacherDiffCallback : DiffUtil.ItemCallback<TeacherInput>() {
        override fun areItemsTheSame(oldItem: TeacherInput, newItem: TeacherInput): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TeacherInput, newItem: TeacherInput): Boolean {
            return oldItem == newItem
        }
    }
}
