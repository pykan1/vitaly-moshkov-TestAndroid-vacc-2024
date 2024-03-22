package com.example.foodapp.data.repository

import com.example.foodapp.data.api.FoodApi
import com.example.foodapp.data.mapper.toUI
import com.example.foodapp.domain.models.CategoryUI
import com.example.foodapp.domain.models.FoodDetailUI
import com.example.foodapp.domain.models.FoodUI
import com.example.foodapp.domain.respository.FoodRepository
import com.example.foodapp.platform.Either
import com.example.foodapp.platform.Failure
import com.example.foodapp.platform.apiCall

class FoodRepositoryImpl(private val foodApi: FoodApi) : FoodRepository {
    override suspend fun allCategories(): Either<Failure, List<CategoryUI>> {
        return apiCall(
            call = { foodApi.allCategories() },
            mapResponse = { response ->
                response.categories?.map {
                    it.toUI()
                } ?: emptyList()
            }
        )
    }

    override suspend fun getFoodById(id: String): Either<Failure, FoodDetailUI> {
        return apiCall(
            call = { foodApi.getFoodById(id) },
            mapResponse = {
                it.meals?.map { it.toUI() }?.getOrNull(0) ?: FoodDetailUI.Default
            }
        )
    }

    override suspend fun getFoodsByCategory(category: String): Either<Failure, List<FoodUI>> {
        return apiCall(
            call = {
                foodApi.getFoodByCategory(category)
            },
            mapResponse = {
                it.meals?.map { it.toUI() }.orEmpty()
            }
        )
    }
}