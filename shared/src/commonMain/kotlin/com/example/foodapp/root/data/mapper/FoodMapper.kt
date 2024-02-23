package com.example.foodapp.root.data.mapper

import com.example.foodapp.root.data.models.food.FoodResponse
import com.example.foodapp.root.domain.models.FoodUI

fun FoodResponse.toUI(): FoodUI {
    return FoodUI(
        idMeal = idMeal.orEmpty(),
        strMealThumb = strMealThumb.orEmpty(),
        strMeal = strMeal.orEmpty()
    )
}