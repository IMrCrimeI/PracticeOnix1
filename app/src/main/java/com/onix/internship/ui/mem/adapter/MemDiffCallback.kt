package com.onix.internship.ui.mem.adapter

import androidx.recyclerview.widget.DiffUtil
import com.onix.internship.entity.MemInfo

class MemDiffCallback : DiffUtil.ItemCallback<MemInfo>() {
    override fun areItemsTheSame(oldItem: MemInfo, newItem: MemInfo): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: MemInfo, newItem: MemInfo): Boolean {
        return oldItem.id == newItem.id
    }
}