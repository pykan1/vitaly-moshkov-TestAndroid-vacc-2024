package com.example.foodapp.di

import com.example.foodapp.platform.DriverFactory
import com.example.foodapp.platform.createDatabase
import org.koin.dsl.module

val platformModule = module {
    single { createDatabase(DriverFactory(get())) }
}