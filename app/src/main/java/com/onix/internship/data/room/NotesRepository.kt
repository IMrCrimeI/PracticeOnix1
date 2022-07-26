package com.onix.internship.data.room

import android.content.Context

class NotesRepository(context: Context) {
    private val db = AppDatabase.getDataBase(context.applicationContext).notesDao()

    fun getAll(): List<Notes> {
        return db.getAll()
    }

    fun addNotes(notes: Notes) {
        db.addNotes(notes)
    }

    fun updateNotes(notes: Notes) {
        db.update(notes)
    }

    fun deleteNotes(notes: Notes) {
        db.delete(notes)
    }

    fun deleteAllNotes() {
        db.deleteAll()
        db.deleteKey()
    }

}