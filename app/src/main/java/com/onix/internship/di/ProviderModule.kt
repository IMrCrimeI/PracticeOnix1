package com.onix.internship.di

import com.onix.internship.data.point.PointsList
import com.onix.internship.data.role.RoleStates
import com.onix.internship.data.repository.AppSharedPreferences
import com.onix.internship.json.JsonFormatter
import org.koin.dsl.module

val providerModule = module {
    single { AppSharedPreferences(get()) }
    single { JsonFormatter() }
    single { PointsList() }
    single { RoleStates() }
}