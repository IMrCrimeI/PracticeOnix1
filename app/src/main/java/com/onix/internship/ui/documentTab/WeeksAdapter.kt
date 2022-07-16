package com.onix.internship.ui.documentTab

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.onix.internship.data.WeeksItem
import com.onix.internship.databinding.RecyclerViewWeeksItemBinding

class WeeksAdapter(private val onClick: (WeeksItem) -> Unit) :
    ListAdapter<WeeksItem, WeeksAdapter.ViewHolder>(SleepNightDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, onClick)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(
        private val binding: RecyclerViewWeeksItemBinding,
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: WeeksItem, onClick: (WeeksItem) -> Unit) {
            binding.weeksItem = item
            binding.root.setOnClickListener {
                onClick(item)
            }
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RecyclerViewWeeksItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

}


class SleepNightDiffCallback : DiffUtil.ItemCallback<WeeksItem>() {

    override fun areItemsTheSame(oldItem: WeeksItem, newItem: WeeksItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: WeeksItem, newItem: WeeksItem): Boolean {
        return oldItem.itemId == newItem.itemId
    }

}