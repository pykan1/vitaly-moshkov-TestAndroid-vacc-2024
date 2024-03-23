package com.example.foodapp.data.db

import com.example.Database
import com.example.foodapp.domain.models.FoodBucketUI
import com.example.foodapp.domain.models.FoodUI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class FoodDataSource(private val database: Database) {

    private val table = database.foodQueries
    private val scope = CoroutineScope(Job() + Dispatchers.IO)

    fun insertFoodToBucket(foodUI: FoodUI) {
        scope.launch {
            table.insertBucketFood(
                idMeal = foodUI.idMeal,
                strMeal = foodUI.strMeal,
                imgMeal = foodUI.strMealThumb
            )
        }
    }

    suspend fun loadAllBucket(): List<FoodBucketUI> {
        val foods = scope.async {
            table.loadBucketFood().executeAsList().map {
                FoodBucketUI(
                    id = it.id,
                    idMeal = it.idMeal.orEmpty(),
                    strMeal = it.strMeal.orEmpty(),
                    image = it.imgMeal.orEmpty()
                )
            }
        }.await()
        return foods
    }

    fun orderBucket() {
        scope.launch {
            table.orderBucket()
        }
    }

    fun deleteBucketItem(id: Long) {
        scope.launch {
            table.deleteFoodFromBucket(id)
        }
    }

}