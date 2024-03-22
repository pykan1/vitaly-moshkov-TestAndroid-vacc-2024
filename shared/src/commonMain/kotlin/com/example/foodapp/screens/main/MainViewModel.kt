package com.example.foodapp.screens.main

import com.example.foodapp.domain.usecases.GetAllCategoriesUseCase
import com.example.foodapp.platform.BaseScreenModel
import com.example.foodapp.screens.main.MainEvent
import com.example.foodapp.screens.main.MainState
import org.koin.core.component.inject
import org.orbitmvi.orbit.syntax.simple.intent

internal class MainViewModel : BaseScreenModel<MainState, MainEvent>(MainState.InitState) {

    private val getAllCategoriesUseCase: GetAllCategoriesUseCase by inject()

    fun getAllCategories() = intent {
        launchOperation(
            operation = {
                getAllCategoriesUseCase.execute(GetAllCategoriesUseCase.Params(), it)
            },
            success = {
                reduceLocal {
                    state.copy(categories = it)
                }
            },
            failure = {

            }
        )
    }

}