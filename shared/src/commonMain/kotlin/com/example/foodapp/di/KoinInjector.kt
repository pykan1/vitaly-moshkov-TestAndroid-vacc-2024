package com.example.foodapp.di

import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.module.Module

object KoinInjector {

    val koinApp = startKoin {
        loadKoinModules(
            listOf(
                networkModule,
                repositoryModule,
                useCaseModule,
                apiModule
            )
        )
    }

    val koin = koinApp.koin

    fun loadModules(modules: List<Module>) {
        koinApp.koin.loadModules(modules)
    }

}