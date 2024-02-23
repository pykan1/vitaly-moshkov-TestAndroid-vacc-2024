package com.example.foodapp.root.data.models.food

import kotlinx.serialization.Serializable

@Serializable
class FoodsResponse (
    val meals: List<FoodResponse>?
)


@Serializable
class FoodResponse (
    val idMeal: String?,
    val strMeal: String?,
    val strMealThumb: String?
)