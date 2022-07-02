package com.onix.internship.di

import com.onix.internship.data.Transfer
import com.onix.internship.data.TranslationStorage
import com.onix.internship.ui.parser.DictionaryXmlParser
import org.koin.dsl.module

val providerModule = module {
    single { DictionaryXmlParser(get()) }
    single { Transfer(get(), get()) }
    single { TranslationStorage() }
}