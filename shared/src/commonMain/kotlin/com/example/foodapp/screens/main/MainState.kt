package com.example.foodapp.screens.main

import com.example.foodapp.domain.models.CategoryUI

data class MainState(
    val categories: List<CategoryUI>
) {
    companion object {
        val InitState = MainState(categories = emptyList())
    }
}