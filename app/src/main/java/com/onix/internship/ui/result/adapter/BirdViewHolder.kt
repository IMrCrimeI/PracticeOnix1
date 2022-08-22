package com.onix.internship.ui.result.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.onix.internship.databinding.BirdItemBinding
import com.onix.internship.entity.BirdInfo

class BirdViewHolder private constructor(private val binding: BirdItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: BirdInfo, onSensorClickListener: OnBirdClickListener) {
        binding.birdItem = item

        binding.playPauseButton.setOnClickListener {
            onSensorClickListener.playPauseMusic(item)
        }
        binding.mainContainer.setOnClickListener {
            onSensorClickListener.showDetails(item)
        }
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): BirdViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = BirdItemBinding.inflate(layoutInflater, parent, false)
            return BirdViewHolder(binding)
        }
    }
}