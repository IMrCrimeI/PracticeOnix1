package com.onix.internship.ui.notesList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.onix.internship.R
import com.onix.internship.data.NotesColor
import com.onix.internship.data.room.NotesItem
import com.onix.internship.databinding.NoteItemBinding

class NotesAdapter(
    private val expandNote: (NotesItem) -> Unit,
    private val editNote: (NotesItem) -> Unit
) :
    ListAdapter<NotesItem, NotesAdapter.ViewHolder>(DiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, expandNote, editNote)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: NoteItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: NotesItem, expandNote: (NotesItem) -> Unit, editNote: (NotesItem) -> Unit) {
            binding.notes = item
            binding.notesItemTitle.setTextColor(getColor(item.notesColor))

            binding.notesIconState.setOnClickListener {
                expandNote(item)
            }
            binding.editIcon.setOnClickListener {
                editNote(item)
            }
            binding.executePendingBindings()
        }

        private fun getColor(it: NotesColor): Int {
            return when (it) {
                NotesColor.RED -> itemView.context.getColor(R.color.color_text_red)
                NotesColor.YELLOW -> itemView.context.getColor(R.color.color_text_yellow)
                NotesColor.GREEN -> itemView.context.getColor(R.color.color_text_green)
                NotesColor.PURPLE -> itemView.context.getColor(R.color.color_text_violet)
                NotesColor.DARK_BLUE -> itemView.context.getColor(R.color.color_text_dark_blue)
                NotesColor.LIGHT_BLUE -> itemView.context.getColor(R.color.color_text_light_blue)
            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = NoteItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<NotesItem>() {
        override fun areItemsTheSame(oldItem: NotesItem, newItem: NotesItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: NotesItem, newItem: NotesItem): Boolean {
            return oldItem.notesCondition == newItem.notesCondition
        }
    }
}


