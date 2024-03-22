package com.example.foodapp.data.api

import com.example.foodapp.data.models.categories.CategoriesResponse
import com.example.foodapp.data.models.food.FoodsDetailResponse
import com.example.foodapp.data.models.food.FoodsResponse
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Query

interface FoodApi {

    @GET("categories.php")
    suspend fun allCategories(): CategoriesResponse

    @GET("lookup.php")
    suspend fun getFoodById(@Query("i") id: String): FoodsDetailResponse

    @GET("filter.php")
    suspend fun getFoodByCategory(
        @Query("c") category: String
    ): FoodsResponse

}