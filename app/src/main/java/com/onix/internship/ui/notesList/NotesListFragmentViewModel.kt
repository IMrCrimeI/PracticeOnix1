package com.onix.internship.ui.notesList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent
import com.onix.internship.data.NotesToNotesItem
import com.onix.internship.data.room.NotesItem
import com.onix.internship.data.room.NotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesListFragmentViewModel(
    private val notesRepository: NotesRepository,
    private val notesToNotesItem: NotesToNotesItem
) : BaseViewModel() {

    private val _moveNext = SingleLiveEvent<Unit>()
    val moveNext: LiveData<Unit> = _moveNext

    private val _notesList = MutableLiveData<List<NotesItem>>()
    val notesList: LiveData<List<NotesItem>> = _notesList


    init {
        viewModelScope.launch(Dispatchers.IO) {
            notesRepository.deleteAllNotes()
        }
    }

    fun addNoteInRoom() {
        _moveNext.value = Unit
    }

    fun updateNotesItem() {
        viewModelScope.launch(Dispatchers.IO) {
            _notesList.postValue(notesToNotesItem.map(notesRepository.getAll()))
        }
    }

    fun expandNote(it: NotesItem) {
        val test = mutableListOf<NotesItem>()
        _notesList.value?.forEach { note ->
            if (it.uid == note.uid) {
                test.add(note.copy(notesCondition = note.notesCondition.not()))
            } else {
                test.add(note)
            }
        }
        _notesList.value = test
    }
}