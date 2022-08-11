package com.onix.internship.di

import com.onix.internship.ui.cropPhoto.CropPhotoViewModel
import com.onix.internship.ui.editPhoto.EditPhotoViewModel
import com.onix.internship.ui.main.MainViewModel
import com.onix.internship.ui.selectPhoto.SelectPhotoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel() }
    viewModel { SelectPhotoViewModel(get()) }
    viewModel { CropPhotoViewModel() }
    viewModel { EditPhotoViewModel() }
}