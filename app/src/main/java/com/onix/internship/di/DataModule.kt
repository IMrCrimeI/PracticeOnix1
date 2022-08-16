package com.onix.internship.di

import com.onix.internship.data.storage.DeviceGalleryInjector
import org.koin.dsl.module

val dataModule = module {
    single { DeviceGalleryInjector(get()) }
}