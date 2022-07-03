package com.onix.internship.ui.translate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.onix.internship.data.DictionaryItem
import com.onix.internship.databinding.HistoryItemBinding

class HistoryAdapter :
    ListAdapter<DictionaryItem, HistoryAdapter.ViewHolder>(DiffCallBack()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: HistoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: DictionaryItem) {
            binding.text = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = HistoryItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}


class DiffCallBack : DiffUtil.ItemCallback<DictionaryItem>() {

    override fun areItemsTheSame(oldItem: DictionaryItem, newItem: DictionaryItem): Boolean {
        return oldItem.key == newItem.key
    }


    override fun areContentsTheSame(oldItem: DictionaryItem, newItem: DictionaryItem): Boolean {
        return oldItem == newItem
    }

}