package com.onix.internship.ui.result.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.onix.internship.databinding.BirdItemBinding
import com.onix.internship.entity.BirdInfo

class RecyclerViewAdapter(
    private val onSensorClickListener: OnBirdClickListener
) :
    ListAdapter<BirdInfo, RecyclerViewAdapter.ViewHolder>(DiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, onSensorClickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(private val binding: BirdItemBinding) :
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
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = BirdItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<BirdInfo>() {
        override fun areItemsTheSame(oldItem: BirdInfo, newItem: BirdInfo): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: BirdInfo, newItem: BirdInfo): Boolean {
            return oldItem.id == newItem.id
        }
    }
}