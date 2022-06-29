package com.onix.internship.di

import com.onix.internship.ui.parser.DictionaryXmlParser
import com.onix.internship.ui.data.Bind
import com.onix.internship.ui.data.TranslationStorage
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val providerModule = module {
    single { DictionaryXmlParser(context = androidApplication()) }
    single { Bind(get(), get()) }
    single { TranslationStorage() }
}