package com.onix.internship.di

import com.onix.internship.ui.choice.ChoiceViewModel
import com.onix.internship.ui.display.DisplayViewModel
import com.onix.internship.ui.game.GameViewModel
import com.onix.internship.ui.main.MainViewModel
import com.onix.internship.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel() }
    viewModel { DisplayViewModel() }
    viewModel { ChoiceViewModel() }
    viewModel { GameViewModel() }
    viewModel { SplashViewModel() }
}