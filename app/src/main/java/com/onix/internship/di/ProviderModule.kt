package com.onix.internship.di

import com.onix.internship.data.storage.ImageStorage
import org.koin.dsl.module

val providerModule = module {
    single { ImageStorage() }
}