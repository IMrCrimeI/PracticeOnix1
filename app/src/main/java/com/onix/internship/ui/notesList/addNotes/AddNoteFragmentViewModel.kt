package com.onix.internship.ui.notesList.addNotes

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent
import com.onix.internship.data.NotesColor
import com.onix.internship.data.room.Notes
import com.onix.internship.data.room.NotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNoteFragmentViewModel(private val notesRepository: NotesRepository) : BaseViewModel() {
    private val _moveBack = SingleLiveEvent<Unit>()
    val moveBack: LiveData<Unit> = _moveBack

    val model = AddNoteFragmentModel()

    fun createNote() {
        val note = Notes(
            0,
            model.title.get().toString(),
            model.contents.get().toString(),
            model.color.get()!!,
            model.editable.get()
        )

        viewModelScope.launch(Dispatchers.IO) {
            notesRepository.addNotes(note)
            _moveBack.postValue(Unit)
        }
    }

    fun selectColor(it: NotesColor) {
        model.color.set(it)
    }
}