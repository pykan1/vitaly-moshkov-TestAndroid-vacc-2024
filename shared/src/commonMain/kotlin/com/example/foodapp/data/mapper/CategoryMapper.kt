package com.example.foodapp.data.mapper

import com.example.foodapp.data.models.categories.CategoryResponse
import com.example.foodapp.domain.models.CategoryUI

fun CategoryResponse.toUI(): CategoryUI {
    return  CategoryUI(
        idCategory = idCategory.orEmpty(),
        strCategory = strCategory.orEmpty(),
        strCategoryThumb = strCategoryThumb.orEmpty(),
        strCategoryDescription = strCategoryDescription.orEmpty()
    )
}