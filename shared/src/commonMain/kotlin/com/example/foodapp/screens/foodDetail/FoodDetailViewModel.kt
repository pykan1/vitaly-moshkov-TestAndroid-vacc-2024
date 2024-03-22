package com.example.foodapp.screens.foodDetail

import com.example.foodapp.domain.usecases.GetFoodByIdUseCase
import com.example.foodapp.platform.BaseScreenModel
import com.example.foodapp.screens.foodDetail.FoodDetailEvent
import com.example.foodapp.screens.foodDetail.FoodDetailState
import org.koin.core.component.inject
import org.orbitmvi.orbit.syntax.simple.intent

internal class FoodDetailViewModel: BaseScreenModel<FoodDetailState, FoodDetailEvent>(
    FoodDetailState.InitState) {

    private val getFoodByIdUseCase: GetFoodByIdUseCase by inject()

    fun loadFoodById(id: String) = intent {
        launchOperation(
            operation = {
                getFoodByIdUseCase.execute(GetFoodByIdUseCase.Params(id = id), it)
            },
            success = {
                reduceLocal {
                    state.copy(
                        foodDetailUI = it
                    )
                }
            }
        )
    }

}