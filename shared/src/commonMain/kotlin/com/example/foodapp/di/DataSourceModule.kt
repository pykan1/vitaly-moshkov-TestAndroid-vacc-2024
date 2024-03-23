package com.example.foodapp.di

import com.example.foodapp.data.db.FoodDataSource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val DataSourceModule = module {
    singleOf(::FoodDataSource)
}