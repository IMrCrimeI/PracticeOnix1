package com.onix.internship.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.onix.internship.data.NotesColor

@Entity(tableName = "notes_table")
data class Notes(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo(name = NOTES_TITLE) var notesTitle: String,
    @ColumnInfo(name = NOTES_CONTENTS) var notesContents: String,
    @ColumnInfo(name = NOTES_COLOR) var notesColor: NotesColor,
    @ColumnInfo(name = NOTES_EDIT) var notesEdit: Boolean
) {
    companion object {
        const val NOTES_TITLE = "notes_title"
        const val NOTES_CONTENTS = "notes_contents"
        const val NOTES_COLOR = "notes_color"
        const val NOTES_EDIT = "notes_edit"
    }
}