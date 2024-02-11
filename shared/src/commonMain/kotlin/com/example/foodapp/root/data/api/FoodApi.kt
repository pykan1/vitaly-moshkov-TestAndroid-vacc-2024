package com.example.foodapp.root.data.api

import com.example.foodapp.root.data.models.categories.CategoriesResponse
import com.example.foodapp.root.data.models.categories.CategoryResponse
import de.jensklingenberg.ktorfit.http.GET

interface FoodApi {

    @GET("categories.php")
    suspend fun allCategories(): CategoriesResponse

}