package com.example.foodapp.root.screens.foodDetail

import com.example.foodapp.root.domain.usecases.GetFoodByIdUseCase
import com.example.foodapp.root.platform.BaseScreenModel
import org.koin.core.component.inject
import org.orbitmvi.orbit.syntax.simple.intent

internal class FoodDetailViewModel: BaseScreenModel<FoodDetailState, FoodDetailEvent>(FoodDetailState.InitState) {

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