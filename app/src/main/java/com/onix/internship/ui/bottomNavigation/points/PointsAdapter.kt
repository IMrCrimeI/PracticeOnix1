package com.onix.internship.ui.bottomNavigation.points

import android.icu.text.SimpleDateFormat
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.onix.internship.data.point.PointItem
import com.onix.internship.databinding.PointsItemBinding

class PointsAdapter(private val onClick: (PointItem) -> Unit) :
    ListAdapter<PointItem, PointsAdapter.ViewHolder>(SleepNightDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, onClick)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(
        private val binding: PointsItemBinding,
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PointItem, onClick: (PointItem) -> Unit) {
            binding.dataAndTimeText.text = calendarToDate(item)
            binding.roleAndLevelText.text = "${item.role} Level ${item.level}"

            binding.root.setOnClickListener {
                onClick(item)
            }
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = PointsItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }

        private fun calendarToDate(item: PointItem): String {
            val dateFormat = SimpleDateFormat("dd.MM.yyyy")
            val timeFromat = SimpleDateFormat("hh:mm")
            val date = dateFormat.format(item.calendar)
            val time = timeFromat.format(item.calendar)
            return "Available $date at $time"
        }
    }
}


class SleepNightDiffCallback : DiffUtil.ItemCallback<PointItem>() {

    override fun areItemsTheSame(oldItem: PointItem, newItem: PointItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: PointItem, newItem: PointItem): Boolean {
        return oldItem.location == newItem.location
    }
}