package com.example.timeatbleschedulerapp.ui.screens.coordinator.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.timeatbleschedulerapp.databinding.ItemStudentGroupInputBinding
import com.example.timeatbleschedulerapp.data.models.StudentGroupInput

class StudentGroupInputAdapter(
    private val onEditClick: (StudentGroupInput) -> Unit,
    private val onDeleteClick: (StudentGroupInput) -> Unit
) : ListAdapter<StudentGroupInput, StudentGroupInputAdapter.GroupViewHolder>(GroupDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        val binding = ItemStudentGroupInputBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return GroupViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class GroupViewHolder(
        private val binding: ItemStudentGroupInputBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(group: StudentGroupInput) {
            binding.apply {
                tvGroupName.text = group.name
                tvGroupCode.text = group.code
                tvSemester.text = "Semester ${group.semester}"
                tvStudentCount.text = "${group.studentCount} students"
                tvSubjects.text = "Subjects: ${group.subjects.size}"

                btnEdit.setOnClickListener { onEditClick(group) }
                btnDelete.setOnClickListener { onDeleteClick(group) }
            }
        }
    }

    private class GroupDiffCallback : DiffUtil.ItemCallback<StudentGroupInput>() {
        override fun areItemsTheSame(oldItem: StudentGroupInput, newItem: StudentGroupInput): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: StudentGroupInput, newItem: StudentGroupInput): Boolean {
            return oldItem == newItem
        }
    }
}
