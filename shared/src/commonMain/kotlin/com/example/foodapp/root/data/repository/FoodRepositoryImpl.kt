package com.example.foodapp.root.data.repository

import com.example.foodapp.root.data.api.FoodApi
import com.example.foodapp.root.data.mapper.toUI
import com.example.foodapp.root.domain.models.CategoryUI
import com.example.foodapp.root.domain.respository.FoodRepository
import com.example.foodapp.root.platform.Either
import com.example.foodapp.root.platform.Failure
import com.example.foodapp.root.platform.apiCall

class FoodRepositoryImpl(private val foodApi: FoodApi) : FoodRepository {
    override suspend fun allCategories(): Either<Failure, List<CategoryUI>> {
        return apiCall(
            call = { foodApi.allCategories() },
            mapResponse = { response ->
                response.categories?.map {
                    it.toUI()
                }?: emptyList()
            }
        )
    }
}