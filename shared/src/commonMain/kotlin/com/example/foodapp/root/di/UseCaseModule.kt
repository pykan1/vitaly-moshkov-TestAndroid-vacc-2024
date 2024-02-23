package com.example.foodapp.root.di

import com.example.foodapp.root.domain.usecases.FoodByCategoryUseCase
import com.example.foodapp.root.domain.usecases.GetAllCategoriesUseCase
import com.example.foodapp.root.domain.usecases.GetFoodByIdUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

internal val useCaseModule = module {
    factoryOf(::GetAllCategoriesUseCase)
    factoryOf(::GetFoodByIdUseCase)
    factoryOf(::FoodByCategoryUseCase)
}