package com.example.foodapp.root.screens.foodDetail

import com.example.foodapp.root.domain.models.FoodDetailUI

data class FoodDetailState(
    val foodDetailUI: FoodDetailUI
) {
    companion object {
        val InitState = FoodDetailState(foodDetailUI = FoodDetailUI.Default)
    }
}