package com.onix.internship.ui.mem.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.onix.internship.entity.MemInfo

class RecyclerViewAdapter :
    ListAdapter<MemInfo, MemViewHolder>(MemDiffCallback()) {

    override fun onBindViewHolder(holder: MemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemViewHolder {
        return MemViewHolder.from(parent)
    }
}