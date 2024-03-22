package com.example.foodapp.domain.models

class FoodUI(
    val idMeal: String,
    val strMeal: String,
    val strMealThumb: String
) {
    companion object {
        val Default = FoodUI(
            "", "", ""
        )
    }
}