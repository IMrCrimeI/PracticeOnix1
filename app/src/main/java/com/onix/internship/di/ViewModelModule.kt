package com.onix.internship.di

import com.onix.internship.ui.bottomNavigation.MainMenuScreenViewModel
import com.onix.internship.ui.firstSetting.age.AgeVerificationViewModel
import com.onix.internship.ui.firstSetting.role.RoleVerificationViewModel
import com.onix.internship.ui.firstSetting.skill.SkillVerificationViewModel
import com.onix.internship.ui.main.MainViewModel
import com.onix.internship.ui.bottomNavigation.map.MapScreenViewModel
import com.onix.internship.ui.bottomNavigation.points.PointsScreenViewModel
import com.onix.internship.ui.bottomNavigation.settings.SettingsScreenViewModel
import com.onix.internship.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SplashViewModel() }
    viewModel { MainViewModel() }
    viewModel { MapScreenViewModel() }
    viewModel { AgeVerificationViewModel() }
    viewModel { SkillVerificationViewModel() }
    viewModel { RoleVerificationViewModel() }
    viewModel { PointsScreenViewModel(get()) }
    viewModel { SettingsScreenViewModel() }
    viewModel { MainMenuScreenViewModel() }
}