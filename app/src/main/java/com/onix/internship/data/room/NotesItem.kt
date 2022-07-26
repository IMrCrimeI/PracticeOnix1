package com.onix.internship.data.room

import com.onix.internship.data.NotesColor

data class NotesItem(
    val uid: Int,
    var notesTitle: String,
    var notesContents: String,
    var notesColor: NotesColor,
    var notesEdit: Boolean,
    var notesCondition: Boolean = false
)
