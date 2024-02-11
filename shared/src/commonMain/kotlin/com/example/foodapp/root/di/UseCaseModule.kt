package com.example.foodapp.root.di

import com.example.foodapp.root.domain.usecases.GetAllCategoriesUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

internal val useCaseModule = module {
    factoryOf(::GetAllCategoriesUseCase)
}