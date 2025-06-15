package com.example.timeatbleschedulerapp.ui.screens.coordinator.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.timeatbleschedulerapp.R
import com.example.timeatbleschedulerapp.data.models.TimetableEntry
import com.example.timeatbleschedulerapp.databinding.ItemTimetablePreviewBinding

class TimetablePreviewAdapter : ListAdapter<TimetableEntry, TimetablePreviewAdapter.PreviewViewHolder>(TimetableDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PreviewViewHolder {
        val binding = ItemTimetablePreviewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PreviewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PreviewViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class PreviewViewHolder(
        private val binding: ItemTimetablePreviewBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(entry: TimetableEntry) {
            binding.apply {
                tvDay.text = entry.day
                tvTimeSlot.text = "${entry.startTime} - ${entry.endTime}"
                tvSubjectName.text = entry.subjectName
                tvTeacherName.text = entry.teacherName
                tvRoomLocation.text = entry.roomId
                tvGroupId.text = entry.groupId
                tvStudentCount.text = "${entry.students} students"

                // Set type indicator with colors
                when (entry.type.lowercase()) {
                    "lecture" -> {
                        tvTypeIndicator.text = "📚 Lecture"
                        tvTypeIndicator.setTextColor(ContextCompat.getColor(itemView.context, R.color.purple_500))
                        cardContainer.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.purple_50))
                    }
                    "lab" -> {
                        tvTypeIndicator.text = "💻 Lab"
                        tvTypeIndicator.setTextColor(ContextCompat.getColor(itemView.context, R.color.teal_700))
                        cardContainer.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.teal_50))
                    }
                    "tutorial" -> {
                        tvTypeIndicator.text = "📝 Tutorial"
                        tvTypeIndicator.setTextColor(ContextCompat.getColor(itemView.context, R.color.orange_500))
                        cardContainer.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.orange_50))
                    }
                    else -> {
                        tvTypeIndicator.text = "📖 Class"
                        tvTypeIndicator.setTextColor(ContextCompat.getColor(itemView.context, R.color.blue_500))
                        cardContainer.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.blue_50))
                    }
                }
            }
        }
    }

    private class TimetableDiffCallback : DiffUtil.ItemCallback<TimetableEntry>() {
        override fun areItemsTheSame(oldItem: TimetableEntry, newItem: TimetableEntry): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TimetableEntry, newItem: TimetableEntry): Boolean {
            return oldItem == newItem
        }
    }
}
