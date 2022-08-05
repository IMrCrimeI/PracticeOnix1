package com.onix.internship.ui.sensors.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.onix.internship.R
import com.onix.internship.databinding.CardsItemBinding
import com.onix.internship.entity.DeviceData
import java.util.*

class SensorsAdapter(
    private val onSensorClickListener: OnSensorClickListener
) :
    ListAdapter<DeviceData, SensorsAdapter.ViewHolder>(DiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, onSensorClickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(private val binding: CardsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: DeviceData, onSensorClickListener: OnSensorClickListener) {
            binding.cardsItem = item

            deviceValue(item.value.toString())

            binding.cardItemTextType.text = itemView.context.getString(
                R.string.type,
                item.type.toString().lowercase()
                    .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
            )
            binding.cardItemTextSubType.text =
                itemView.context.getString(R.string.subtype, item.subType.toString().lowercase()
                    .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() })

            binding.deleteSensorButton.setOnClickListener {
                onSensorClickListener.deleteSensor(item)
            }
            binding.executePendingBindings()
        }

        private fun deviceValue(value: String) {
            if (value.contains("https://")) {
                Glide.with(itemView.context)
                    .load(Uri.parse(value))
                    .into(binding.cardItemImg)
            } else {
                binding.cardItemImg.setImageResource(R.drawable.ic_none_image)
            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CardsItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<DeviceData>() {
        override fun areItemsTheSame(oldItem: DeviceData, newItem: DeviceData): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: DeviceData, newItem: DeviceData): Boolean {
            return oldItem.id == newItem.id
        }
    }
}