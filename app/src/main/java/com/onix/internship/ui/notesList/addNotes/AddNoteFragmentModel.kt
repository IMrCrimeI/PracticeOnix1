package com.onix.internship.ui.notesList.addNotes

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import com.onix.internship.data.NotesColor

data class AddNoteFragmentModel(
    val title: ObservableField<String> = ObservableField(""),
    val contents: ObservableField<String> = ObservableField(""),
    val editable: ObservableBoolean = ObservableBoolean(false),
    val color: ObservableField<NotesColor> = ObservableField()
)
