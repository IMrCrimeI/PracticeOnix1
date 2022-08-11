package com.onix.internship.di

import com.onix.internship.ui.editPhoto.injector.DeviceGalleryInjector
import org.koin.dsl.module

val injectorModule = module {
    single { DeviceGalleryInjector(get()) }
}