package com.onix.internship.ui.translationsList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.onix.internship.data.DictionaryItem
import com.onix.internship.databinding.TranslationItemPolishUkrainanBinding

class ResultsAdapterPolishUkrainian :
    ListAdapter<DictionaryItem, ResultsAdapterPolishUkrainian.ViewHolder>(DiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(
        val binding: TranslationItemPolishUkrainanBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DictionaryItem) {
            binding.text = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding =
                    TranslationItemPolishUkrainanBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}


class DiffCallback : DiffUtil.ItemCallback<DictionaryItem>() {

    override fun areItemsTheSame(oldItem: DictionaryItem, newItem: DictionaryItem): Boolean {
        return oldItem.value == newItem.value
    }


    override fun areContentsTheSame(oldItem: DictionaryItem, newItem: DictionaryItem): Boolean {
        return oldItem == newItem
    }

}
