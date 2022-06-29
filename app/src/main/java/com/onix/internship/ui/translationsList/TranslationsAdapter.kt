package com.onix.internship.ui.translationsList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.onix.internship.databinding.TranslationItemBinding
import com.onix.internship.ui.data.DictionaryItem

class TranslationsAdapter :
    ListAdapter<DictionaryItem, TranslationsAdapter.ViewHolder>(SleepNightDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: TranslationItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: DictionaryItem) {
            binding.text = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = TranslationItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}


class SleepNightDiffCallback : DiffUtil.ItemCallback<DictionaryItem>() {

    override fun areItemsTheSame(oldItem: DictionaryItem, newItem: DictionaryItem): Boolean {
        return oldItem.key == newItem.key
    }


    override fun areContentsTheSame(oldItem: DictionaryItem, newItem: DictionaryItem): Boolean {
        return oldItem == newItem
    }

}
