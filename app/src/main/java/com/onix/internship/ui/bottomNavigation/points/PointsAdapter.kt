package com.onix.internship.ui.bottomNavigation.points

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.onix.internship.data.PointItem
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
            binding.pointItem = item
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
    }

}


class SleepNightDiffCallback : DiffUtil.ItemCallback<PointItem>() {

    override fun areItemsTheSame(oldItem: PointItem, newItem: PointItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: PointItem, newItem: PointItem): Boolean {
        return oldItem.id == newItem.id
    }

}