package com.example.foodapp.screens.bucket

import com.example.foodapp.data.db.FoodDataSource
import com.example.foodapp.platform.BaseScreenModel
import org.koin.core.component.inject
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce

internal class BucketViewModel : BaseScreenModel<BucketState, BucketEvent>(BucketState.InitState) {

    private val foodDataSource: FoodDataSource by inject()

    fun loadBucket() = intent {
        val items = foodDataSource.loadAllBucket()
        reduce {
            state.copy(
                items = items
            )
        }
    }

    fun order() = intent {
        foodDataSource.orderBucket()
        reduce {
            state.copy(items = emptyList())
        }

    }

    fun deleteItem(id: Long) = intent {
        foodDataSource.deleteBucketItem(id)
        reduce {
            state.copy(
                items = state.items.filter { it.id != id }
            )
        }
    }

}