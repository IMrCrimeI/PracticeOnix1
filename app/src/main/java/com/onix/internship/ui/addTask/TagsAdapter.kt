package com.onix.internship.ui.addTask

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.onix.internship.data.TagsItem
import com.onix.internship.databinding.RecyclerViewTagsItemBinding

class TagsAdapter(private val onClick: (TagsItem) -> Unit) :
    ListAdapter<TagsItem, TagsAdapter.ViewHolder>(SleepNightDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, onClick)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(
        private val binding: RecyclerViewTagsItemBinding,
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TagsItem, onClick: (TagsItem) -> Unit) {
            binding.tagsItem = item
            binding.root.setOnClickListener {
                onClick(item)
            }
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RecyclerViewTagsItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

}


class SleepNightDiffCallback : DiffUtil.ItemCallback<TagsItem>() {

    override fun areItemsTheSame(oldItem: TagsItem, newItem: TagsItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: TagsItem, newItem: TagsItem): Boolean {
        return oldItem.tagsId == newItem.tagsId
    }

}