package com.onix.internship.di

import com.onix.internship.data.storage.BirdDetailsStorage
import com.onix.internship.data.storage.SearchStorage
import com.onix.internship.ui.result.MediaPlayerProvider
import org.koin.dsl.module

val providerModule = module {
    single { SearchStorage() }
    single { BirdDetailsStorage() }
    single { MediaPlayerProvider() }
}