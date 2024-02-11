package com.example.foodapp.root.di

import com.example.foodapp.root.data.api.FoodApi
import de.jensklingenberg.ktorfit.Ktorfit
import org.koin.dsl.module

internal val apiModule = module {
    factory { get<Ktorfit>().create<FoodApi>() }
}