package com.example.timeatbleschedulerapp.ui.screens.coordinator.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.timeatbleschedulerapp.databinding.ItemRoomInputBinding
import com.example.timeatbleschedulerapp.data.models.RoomInput

class RoomInputAdapter(
    private val onEditClick: (RoomInput) -> Unit,
    private val onDeleteClick: (RoomInput) -> Unit
) : ListAdapter<RoomInput, RoomInputAdapter.RoomViewHolder>(RoomDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        val binding = ItemRoomInputBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return RoomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class RoomViewHolder(
        private val binding: ItemRoomInputBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(room: RoomInput) {
            binding.apply {
                tvRoomNumber.text = room.number
                tvRoomName.text = room.name
                tvCapacity.text = "Capacity: ${room.capacity}"
                tvRoomType.text = room.type.name
                chipHasProjector.isChecked = room.hasProjector
                chipHasComputers.isChecked = room.hasComputers
                chipHasWhiteboard.isChecked = room.hasWhiteboard

                btnEdit.setOnClickListener { onEditClick(room) }
                btnDelete.setOnClickListener { onDeleteClick(room) }
            }
        }
    }

    private class RoomDiffCallback : DiffUtil.ItemCallback<RoomInput>() {
        override fun areItemsTheSame(oldItem: RoomInput, newItem: RoomInput): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: RoomInput, newItem: RoomInput): Boolean {
            return oldItem == newItem
        }
    }
}
