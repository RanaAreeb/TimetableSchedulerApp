package com.example.timeatbleschedulerapp.ui.screens.timetable.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.timeatbleschedulerapp.R
import com.example.timeatbleschedulerapp.data.models.TimetableEntry
import com.example.timeatbleschedulerapp.databinding.ItemTimetableViewBinding

class TimetableViewAdapter : ListAdapter<TimetableEntry, TimetableViewAdapter.TimetableViewHolder>(TimetableDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimetableViewHolder {
        val binding = ItemTimetableViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TimetableViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TimetableViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class TimetableViewHolder(
        private val binding: ItemTimetableViewBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(entry: TimetableEntry) {
            binding.apply {
                tvSubjectName.text = entry.subjectName
                tvTeacherName.text = entry.teacherName
                tvRoomLocation.text = entry.roomId
                tvTimeSlot.text = "${entry.startTime} - ${entry.endTime}"
                tvStudentCount.text = "${entry.students} students"

                // Set type indicator
                when (entry.type.lowercase()) {
                    "lecture" -> {
                        tvTypeIndicator.text = "📚 Lecture"
                        tvTypeIndicator.setTextColor(ContextCompat.getColor(itemView.context, R.color.purple_500))
                        cardTypeIndicator.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.purple_100))
                    }
                    "lab" -> {
                        tvTypeIndicator.text = "💻 Lab"
                        tvTypeIndicator.setTextColor(ContextCompat.getColor(itemView.context, R.color.teal_700))
                        cardTypeIndicator.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.teal_100))
                    }
                    "tutorial" -> {
                        tvTypeIndicator.text = "📝 Tutorial"
                        tvTypeIndicator.setTextColor(ContextCompat.getColor(itemView.context, R.color.orange_500))
                        cardTypeIndicator.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.orange_100))
                    }
                    else -> {
                        tvTypeIndicator.text = "📖 Class"
                        tvTypeIndicator.setTextColor(ContextCompat.getColor(itemView.context, R.color.blue_500))
                        cardTypeIndicator.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.blue_100))
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
