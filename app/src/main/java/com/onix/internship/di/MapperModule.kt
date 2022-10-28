package com.onix.internship.di

import com.onix.internship.data.mapper.UserMapper
import org.koin.dsl.module

val mapperModule = module {
    single { UserMapper() }
}