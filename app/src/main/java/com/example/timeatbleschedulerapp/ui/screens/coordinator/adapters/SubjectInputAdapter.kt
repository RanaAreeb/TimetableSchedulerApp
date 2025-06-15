package com.example.timeatbleschedulerapp.ui.screens.coordinator.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.timeatbleschedulerapp.databinding.ItemSubjectInputBinding
import com.example.timeatbleschedulerapp.data.models.SubjectInput

class SubjectInputAdapter(
    private val onEditClick: (SubjectInput) -> Unit,
    private val onDeleteClick: (SubjectInput) -> Unit
) : ListAdapter<SubjectInput, SubjectInputAdapter.SubjectViewHolder>(SubjectDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
        val binding = ItemSubjectInputBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return SubjectViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class SubjectViewHolder(
        private val binding: ItemSubjectInputBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(subject: SubjectInput) {
            binding.apply {
                tvSubjectName.text = subject.name
                tvSubjectCode.text = subject.code
                tvHoursPerWeek.text = "${subject.hoursPerWeek} hours/week"
                tvSubjectType.text = subject.type.name
                chipRequiresLab.isChecked = subject.requiresLab
                chipRequiresProjector.isChecked = subject.requiresProjector

                btnEdit.setOnClickListener { onEditClick(subject) }
                btnDelete.setOnClickListener { onDeleteClick(subject) }
            }
        }
    }

    private class SubjectDiffCallback : DiffUtil.ItemCallback<SubjectInput>() {
        override fun areItemsTheSame(oldItem: SubjectInput, newItem: SubjectInput): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: SubjectInput, newItem: SubjectInput): Boolean {
            return oldItem == newItem
        }
    }
}
