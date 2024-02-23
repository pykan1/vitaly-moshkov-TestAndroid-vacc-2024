package com.example.foodapp.root.domain.respository

import com.example.foodapp.root.domain.models.CategoryUI
import com.example.foodapp.root.domain.models.FoodDetailUI
import com.example.foodapp.root.domain.models.FoodUI
import com.example.foodapp.root.platform.Either
import com.example.foodapp.root.platform.Failure

interface FoodRepository {

    suspend fun allCategories(): Either<Failure, List<CategoryUI>>

    suspend fun getFoodById(id: String) : Either<Failure, FoodDetailUI>

    suspend fun getFoodsByCategory(category: String): Either<Failure, List<FoodUI>>

}