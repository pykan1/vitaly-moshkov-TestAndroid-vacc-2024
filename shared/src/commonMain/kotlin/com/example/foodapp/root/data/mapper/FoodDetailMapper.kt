package com.example.foodapp.root.data.mapper

import com.example.foodapp.root.data.models.food.FoodDetailResponse
import com.example.foodapp.root.domain.models.FoodDetailUI

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