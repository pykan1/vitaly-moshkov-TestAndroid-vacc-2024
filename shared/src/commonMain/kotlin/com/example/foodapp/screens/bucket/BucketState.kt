package com.example.foodapp.screens.bucket

import com.example.foodapp.domain.models.FoodBucketUI

data class BucketState (
    val items: List<FoodBucketUI>
) {
    companion object {
        val InitState = BucketState(
            items = emptyList()
        )
    }
}