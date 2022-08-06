package com.onix.internship.di

import com.onix.internship.data.NotesToNotesItem
import com.onix.internship.data.room.NotesRepository
import org.koin.dsl.module

val providerModelModule = module {
    single { NotesRepository(get()) }
    single { NotesToNotesItem() }
}