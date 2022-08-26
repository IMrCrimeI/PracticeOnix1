package com.onix.internship.ui.mem.adapter

import androidx.recyclerview.widget.RecyclerView
import com.onix.internship.databinding.MemItemBinding
import com.onix.internship.entity.MemInfo

class MemViewHolder constructor(private val binding: MemItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: MemInfo) {
        binding.memItem = item
        binding.executePendingBindings()
    }
}