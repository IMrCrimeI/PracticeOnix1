package com.onix.internship.di

import com.onix.internship.data.mapper.MemInfoMapper
import com.onix.internship.data.mapper.MemPageInfoMapper
import org.koin.dsl.module

val mapperModule = module {
    single { MemInfoMapper() }
    single { MemPageInfoMapper(get()) }
}