package com.onix.internship.ui.emergency.dialog

import androidx.lifecycle.LiveData
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent
import com.onix.internship.data.room.NotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class EmergencyDialogFragmentViewModel(private val notesRepository: NotesRepository) :
    BaseViewModel() {
    private val _moveBack = SingleLiveEvent<Boolean>()
    val moveBack: LiveData<Boolean> = _moveBack

    fun moveBack(it: Boolean) {
        _moveBack.value = it
    }

    fun deleteAllNotes() {
        launch {
            withContext(Dispatchers.IO) {
                notesRepository.deleteAllNotes()
            }
        }
    }
}