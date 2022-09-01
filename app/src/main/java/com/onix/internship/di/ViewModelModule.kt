package com.onix.internship.di

import com.onix.internship.ui.main.MainViewModel
import com.onix.internship.ui.mem.MemViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel() }
    viewModel { MemViewModel(get()) }
}