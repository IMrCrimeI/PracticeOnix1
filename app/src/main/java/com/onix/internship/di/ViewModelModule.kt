package com.onix.internship.di

import com.onix.internship.ui.emergency.EmergencyFragmentViewModel
import com.onix.internship.ui.emergency.dialog.EmergencyDialogFragmentViewModel
import com.onix.internship.ui.help.HelpFragmentViewModel
import com.onix.internship.ui.main.MainViewModel
import com.onix.internship.ui.notesList.NotesListFragmentViewModel
import com.onix.internship.ui.notesList.addNotes.AddNoteFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel() }
    viewModel { NotesListFragmentViewModel(get(), get()) }
    viewModel { EmergencyFragmentViewModel() }
    viewModel { HelpFragmentViewModel() }
    viewModel { EmergencyDialogFragmentViewModel(get()) }
    viewModel { AddNoteFragmentViewModel(get()) }
}