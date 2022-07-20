package com.onix.internship.di

import android.content.Context
import android.content.SharedPreferences
import com.onix.internship.data.repository.Test
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val providerModule = module {
    single<SharedPreferences> {
        androidContext().getSharedPreferences(
            "mainSettings", Context.MODE_PRIVATE
        )
    }
    single { Test() }
}