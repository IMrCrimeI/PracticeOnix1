package com.onix.internship.di

import com.onix.internship.ui.advanced_search.AdvancedSearchViewModel
import com.onix.internship.ui.home.HomeViewModel
import com.onix.internship.ui.main.MainViewModel
import com.onix.internship.ui.result.ResultViewModel
import com.onix.internship.ui.result.details.DetailsViewModel
import com.onix.internship.ui.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel() }
    viewModel { SearchViewModel() }
    viewModel { AdvancedSearchViewModel() }
    viewModel { HomeViewModel() }
    viewModel { ResultViewModel(get(), get()) }
    viewModel { DetailsViewModel(get()) }
}