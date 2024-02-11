package com.example.foodapp.root.screens.main

import com.example.foodapp.root.domain.usecases.GetAllCategoriesUseCase
import com.example.foodapp.root.platform.BaseScreenModel
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