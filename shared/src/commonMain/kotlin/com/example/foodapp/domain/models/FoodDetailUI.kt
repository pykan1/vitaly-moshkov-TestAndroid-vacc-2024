package com.example.foodapp.domain.models

data class FoodDetailUI (
    val idMeal: String,
    val strMeal: String,
    val strCategory: String,
    val strArea: String,
    val strInstructions: String,
    val strYoutube: String,
) {
    companion object {
        val Default = FoodDetailUI(
            "", "", "", "", "", ""
        )
    }
}