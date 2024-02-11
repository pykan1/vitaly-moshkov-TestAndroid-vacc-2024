package com.example.foodapp.root.data.mapper

import com.example.foodapp.root.data.models.categories.CategoryResponse
import com.example.foodapp.root.domain.models.CategoryUI

fun CategoryResponse.toUI(): CategoryUI {
    return  CategoryUI(
        idCategory = idCategory.orEmpty(),
        strCategory = strCategory.orEmpty(),
        strCategoryThumb = strCategoryThumb.orEmpty(),
        strCategoryDescription = strCategoryDescription.orEmpty()
    )
}