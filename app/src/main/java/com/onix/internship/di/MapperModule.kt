package com.onix.internship.di

import com.onix.internship.data.mapper.BirdInfoMapper
import com.onix.internship.data.mapper.PageInfoMapper
import com.onix.internship.data.mapper.SongInfoMapper
import org.koin.dsl.module

val mapperModule = module {
    single { SongInfoMapper() }
    single { BirdInfoMapper(get()) }
    single { PageInfoMapper(get()) }
}