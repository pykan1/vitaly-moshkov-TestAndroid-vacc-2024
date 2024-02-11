package com.example.foodapp.root.screens.main

import com.example.foodapp.root.domain.models.CategoryUI

data class MainState(
    val categories: List<CategoryUI>
) {
    companion object {
        val InitState = MainState(categories = emptyList())
    }
}