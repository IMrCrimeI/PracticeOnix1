package com.onix.internship.di

import com.onix.internship.data.repository.NetworkRepository
import com.onix.internship.data.repository.MemRepository
import com.onix.internship.network.NetworkFactory
import com.onix.internship.network.NetworkService
import org.koin.dsl.module

val networkModule = module {
    single { NetworkFactory() }
    single { get<NetworkFactory>().createService(NetworkService::class.java) }
    single { NetworkRepository(get(), get()) }
    single { MemRepository(get()) }
}