package com.onix.internship.di

import android.content.Context
import com.onix.internship.ui.wifi.WifiScanner
import org.koin.dsl.module

val managerModule = module {
    single { WifiScanner(get<Context>()) }
}