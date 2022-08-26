package com.onix.internship.ui.mem.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.onix.internship.databinding.MemItemBinding
import com.onix.internship.entity.MemInfo

class RecyclerViewAdapter : PagingDataAdapter<MemInfo, MemViewHolder>(MemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemViewHolder =
        MemViewHolder(
            MemItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            )
        )

    override fun onBindViewHolder(holder: MemViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bind(item)
        }
    }
}