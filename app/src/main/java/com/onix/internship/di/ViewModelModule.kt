package com.onix.internship.di

import com.onix.internship.ui.game.secondSceneAlternate.SecondSceneAlternateViewModel
import com.onix.internship.ui.game.mainMenu.MainMenuViewModel
import com.onix.internship.ui.game.thirdScene.ThirdSceneViewModel
import com.onix.internship.ui.game.secondScene.SecondSceneViewModel
import com.onix.internship.ui.game.firstScene.FirstSceneViewModel
import com.onix.internship.ui.game.settingsDialogFragment.SettingsDialogFragmentViewModel
import com.onix.internship.ui.main.MainViewModel
import com.onix.internship.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SplashViewModel() }
    viewModel { MainViewModel() }
    viewModel { MainMenuViewModel() }
    viewModel { FirstSceneViewModel(get())}
    viewModel { SecondSceneViewModel(get()) }
    viewModel { ThirdSceneViewModel(get()) }
    viewModel { SecondSceneAlternateViewModel(get()) }
    viewModel { SettingsDialogFragmentViewModel() }
}