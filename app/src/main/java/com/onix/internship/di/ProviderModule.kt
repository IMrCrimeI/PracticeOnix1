package com.onix.internship.di

import com.onix.internship.data.DialogueList
import org.koin.dsl.module

val providerModule = module {
    single { DialogueList() }
}