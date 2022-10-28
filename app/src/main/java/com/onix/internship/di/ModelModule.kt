package com.onix.internship.di

import com.onix.internship.ui.user.UserModel
import org.koin.dsl.module

val modelModule = module {
    single { UserModel() }
}