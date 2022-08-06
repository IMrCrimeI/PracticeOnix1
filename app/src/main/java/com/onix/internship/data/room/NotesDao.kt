package com.onix.internship.data.room

import androidx.room.*

@Dao
interface NotesDao {
    @Query("SELECT * FROM notes_table")
    fun getAll(): List<Notes>

    @Insert
    fun addNotes(notes: Notes)

    @Update
    fun update(notes: Notes)

    @Query("DELETE FROM notes_table")
    fun deleteAll()

    @Query("DELETE FROM sqlite_sequence")
    fun deleteKey()

    @Delete
    fun delete(notes: Notes)
}