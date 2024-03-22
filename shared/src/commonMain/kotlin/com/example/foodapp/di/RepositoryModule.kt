package com.example.foodapp.di

import com.example.foodapp.data.repository.FoodRepositoryImpl
import com.example.foodapp.domain.respository.FoodRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

internal val repositoryModule = module {
    factoryOf(::FoodRepositoryImpl) { bind<FoodRepository>() }
}