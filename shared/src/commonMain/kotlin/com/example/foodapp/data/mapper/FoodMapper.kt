package com.example.foodapp.data.mapper

import com.example.foodapp.data.models.food.FoodResponse
import com.example.foodapp.domain.models.FoodUI

fun FoodResponse.toUI(): FoodUI {
    return FoodUI(
        idMeal = idMeal.orEmpty(),
        strMealThumb = strMealThumb.orEmpty(),
        strMeal = strMeal.orEmpty()
    )
}