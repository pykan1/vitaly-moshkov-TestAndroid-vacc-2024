package com.example.foodapp.root.screens.foodByCategory

import com.example.foodapp.root.domain.usecases.FoodByCategoryUseCase
import com.example.foodapp.root.platform.BaseScreenModel
import org.koin.core.component.inject
import org.orbitmvi.orbit.syntax.simple.intent

internal class FoodByCategoryViewModel : BaseScreenModel<FoodByCategoryState, FoodByCategoryEvent>(
    FoodByCategoryState.InitState
) {

    private val foodByCategoryUseCase: FoodByCategoryUseCase by inject()


    fun loadFoods(category: String) = intent {
        launchOperation(
            operation = {
                foodByCategoryUseCase.execute(FoodByCategoryUseCase.Params(category = category), it)
            },
            success = {
                reduceLocal {
                    state.copy(
                        foods = it
                    )
                }
            }
        )
    }
}

