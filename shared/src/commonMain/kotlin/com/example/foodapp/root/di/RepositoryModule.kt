package com.example.foodapp.root.di

import com.example.foodapp.root.data.repository.FoodRepositoryImpl
import com.example.foodapp.root.domain.respository.FoodRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

internal val repositoryModule = module {
    factoryOf(::FoodRepositoryImpl) { bind<FoodRepository>() }
}