package com.example.foodapp.domain.models

data class FoodBucketUI(
    val id: Long,
    val strMeal: String,
    val image: String,
    val idMeal: String,
) {

    companion object {
        val Default = FoodBucketUI(
            0, "", "", ""
        )
    }
}
