package com.example.foodapp.domain.usecases

import com.example.foodapp.domain.models.FoodDetailUI
import com.example.foodapp.domain.respository.FoodRepository
import com.example.foodapp.platform.BaseUseCase
import com.example.foodapp.platform.Either
import com.example.foodapp.platform.Failure
import kotlinx.coroutines.CoroutineScope

class GetFoodByIdUseCase(private val foodRepository: FoodRepository): BaseUseCase<GetFoodByIdUseCase.Params, FoodDetailUI>() {
    class Params(val id: String)

    override suspend fun execute(
        params: Params,
        scope: CoroutineScope
    ): Either<Failure, FoodDetailUI> {
        return foodRepository.getFoodById(params.id)
    }
}