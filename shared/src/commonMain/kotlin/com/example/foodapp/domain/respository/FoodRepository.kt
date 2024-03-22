package com.example.foodapp.domain.respository

import com.example.foodapp.domain.models.CategoryUI
import com.example.foodapp.domain.models.FoodDetailUI
import com.example.foodapp.domain.models.FoodUI
import com.example.foodapp.platform.Either
import com.example.foodapp.platform.Failure

interface FoodRepository {

    suspend fun allCategories(): Either<Failure, List<CategoryUI>>

    suspend fun getFoodById(id: String) : Either<Failure, FoodDetailUI>

    suspend fun getFoodsByCategory(category: String): Either<Failure, List<FoodUI>>

}