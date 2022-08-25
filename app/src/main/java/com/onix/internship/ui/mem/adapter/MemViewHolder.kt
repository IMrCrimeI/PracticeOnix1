package com.onix.internship.ui.mem.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.onix.internship.databinding.MemItemBinding
import com.onix.internship.entity.MemInfo

class MemViewHolder private constructor(private val binding: MemItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: MemInfo) {
        binding.memItem = item
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): MemViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = MemItemBinding.inflate(layoutInflater, parent, false)
            return MemViewHolder(binding)
        }
    }
}