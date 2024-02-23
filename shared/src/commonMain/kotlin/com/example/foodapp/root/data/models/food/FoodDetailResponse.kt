package com.example.foodapp.root.data.models.food

import kotlinx.serialization.Serializable


@Serializable
class FoodDetailResponse(
    val idMeal: String?,
    val strMeal: String?,
    val strCategory: String?,
    val strArea: String?,
    val strInstructions: String?,
    val strYoutube: String?,
)

@Serializable
class FoodsDetailResponse(
    val meals: List<FoodDetailResponse>?,
)