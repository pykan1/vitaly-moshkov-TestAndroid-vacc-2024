package com.example.foodapp.root.di

import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

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

}