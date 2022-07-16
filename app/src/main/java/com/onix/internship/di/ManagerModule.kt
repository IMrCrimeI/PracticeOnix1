package com.onix.internship.di

import com.onix.internship.data.Repository
import com.onix.internship.data.AppSettings
import org.koin.dsl.module

val managerModule = module {
    single { AppSettings() }
    single { Repository() }
}