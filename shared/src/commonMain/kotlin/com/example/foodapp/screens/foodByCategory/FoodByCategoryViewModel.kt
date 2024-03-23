package com.example.foodapp.screens.foodByCategory

import com.example.foodapp.data.db.FoodDataSource
import com.example.foodapp.domain.models.FoodUI
import com.example.foodapp.domain.usecases.FoodByCategoryUseCase
import com.example.foodapp.platform.BaseScreenModel
import com.example.foodapp.screens.foodByCategory.FoodByCategoryEvent
import com.example.foodapp.screens.foodByCategory.FoodByCategoryState
import org.koin.core.component.inject
import org.orbitmvi.orbit.syntax.simple.intent

internal class FoodByCategoryViewModel : BaseScreenModel<FoodByCategoryState, FoodByCategoryEvent>(
    FoodByCategoryState.InitState
) {

    private val foodByCategoryUseCase: FoodByCategoryUseCase by inject()
    private val dataSource: FoodDataSource by inject()

    fun loadFoods(category: String) = intent {
        launchOperation(
            operation = {
                foodByCategoryUseCase.execute(
                    FoodByCategoryUseCase.Params(category = category),
                    it
                )
            },
            success = {
                reduceLocal {
                    state.copy(
                        foods = it, category = category
                    )
                }
            }
        )
    }

    fun insertInBucket(it: FoodUI) = intent {
        dataSource.insertFoodToBucket(it)
    }
}

