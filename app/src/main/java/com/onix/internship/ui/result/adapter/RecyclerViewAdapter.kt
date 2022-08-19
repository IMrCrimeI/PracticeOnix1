package com.onix.internship.ui.result.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.onix.internship.entity.BirdInfo

class RecyclerViewAdapter(
    private val onSensorClickListener: OnBirdClickListener
) :
    ListAdapter<BirdInfo, BirdViewHolder>(BirdDiffCallback()) {

    override fun onBindViewHolder(holder: BirdViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, onSensorClickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BirdViewHolder {
        return BirdViewHolder.from(parent)
    }
}