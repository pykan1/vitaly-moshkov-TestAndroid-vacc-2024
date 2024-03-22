package com.example.foodapp.data.mapper

import com.example.foodapp.data.models.food.FoodDetailResponse
import com.example.foodapp.domain.models.FoodDetailUI

fun FoodDetailResponse.toUI(): FoodDetailUI {
    return FoodDetailUI(
        idMeal = idMeal.orEmpty(),
        strMeal = strMeal.orEmpty(),
        strCategory = strCategory.orEmpty(),
        strArea = strArea.orEmpty(),
        strInstructions = strInstructions.orEmpty(),
        strYoutube = strYoutube.orEmpty()
    )
}