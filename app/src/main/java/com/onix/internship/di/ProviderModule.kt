package com.onix.internship.di

import com.onix.internship.data.GameResources
import com.onix.internship.data.MediaPlayerWrapper
import org.koin.dsl.module

val providerModule = module {
    single { GameResources(get()) }
    single { MediaPlayerWrapper(get()) }
}