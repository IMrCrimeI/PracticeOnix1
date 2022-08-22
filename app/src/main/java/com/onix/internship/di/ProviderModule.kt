package com.onix.internship.di

import com.onix.internship.ui.result.MediaPlayerProvider
import org.koin.dsl.module

val providerModule = module {
    single { MediaPlayerProvider() }
}