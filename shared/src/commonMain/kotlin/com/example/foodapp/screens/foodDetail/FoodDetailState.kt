package com.example.foodapp.screens.foodDetail

import com.example.foodapp.domain.models.FoodDetailUI

data class FoodDetailState(
    val foodDetailUI: FoodDetailUI
) {
    companion object {
        val InitState = FoodDetailState(foodDetailUI = FoodDetailUI.Default)
    }
}