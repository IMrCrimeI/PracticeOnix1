package com.onix.internship.di

import com.onix.internship.ui.main.MainViewModel
import com.onix.internship.ui.user.UserViewModel
import com.onix.internship.ui.userresult.UserResultViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel() }
    viewModel { UserViewModel(get()) }
    viewModel { UserResultViewModel(get(), get()) }
}