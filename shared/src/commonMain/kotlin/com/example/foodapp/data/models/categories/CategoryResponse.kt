package com.example.foodapp.data.models.categories

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
class CategoriesResponse(
    val categories: List<CategoryResponse>?
)

@Serializable
class CategoryResponse (
    @SerialName("idCategory")
    val idCategory: String?,
    val strCategory: String?,
    val strCategoryThumb: String?,
    val strCategoryDescription: String?,
)