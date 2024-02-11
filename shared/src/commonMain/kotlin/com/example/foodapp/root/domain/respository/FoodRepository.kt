package com.example.foodapp.root.domain.respository

import com.example.foodapp.root.domain.models.CategoryUI
import com.example.foodapp.root.platform.Either
import com.example.foodapp.root.platform.Failure

interface FoodRepository {

    suspend fun allCategories(): Either<Failure, List<CategoryUI>>

}