package com.onix.internship.ui.result.adapter

import androidx.recyclerview.widget.DiffUtil
import com.onix.internship.entity.BirdInfo

class BirdDiffCallback : DiffUtil.ItemCallback<BirdInfo>() {
    override fun areItemsTheSame(oldItem: BirdInfo, newItem: BirdInfo): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: BirdInfo, newItem: BirdInfo): Boolean {
        return oldItem.id == newItem.id
    }
}