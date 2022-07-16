package com.onix.internship.di

import com.onix.internship.ui.activityTab.ActivityTabViewModel
import com.onix.internship.ui.addTags.AddTagsDialogViewModel
import com.onix.internship.ui.addTask.AddTaskViewModel
import com.onix.internship.ui.calendarPicker.CalendarViewModel
import com.onix.internship.ui.documentTab.EmptyTaskViewModel
import com.onix.internship.ui.folderTab.FolderTabViewModel
import com.onix.internship.ui.homeTab.HomeTabViewModel
import com.onix.internship.ui.main.MainViewModel
import com.onix.internship.ui.timePicker.TimeDialogViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { EmptyTaskViewModel(get()) }
    viewModel { HomeTabViewModel() }
    viewModel { ActivityTabViewModel() }
    viewModel { FolderTabViewModel() }
    viewModel { AddTaskViewModel(get(), get()) }
    viewModel { CalendarViewModel() }
    viewModel { TimeDialogViewModel() }
    viewModel { AddTagsDialogViewModel() }
}