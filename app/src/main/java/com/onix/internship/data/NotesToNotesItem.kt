package com.onix.internship.data

import com.onix.internship.arch.Mapper
import com.onix.internship.data.room.Notes
import com.onix.internship.data.room.NotesItem

class NotesToNotesItem : Mapper<Notes, NotesItem>() {
    override fun map(from: Notes): NotesItem {
        return NotesItem(
            uid = from.uid,
            notesTitle = from.notesTitle,
            notesContents = from.notesContents,
            notesColor = from.notesColor,
            notesEdit = from.notesEdit,
            notesCondition = false
        )
    }
}