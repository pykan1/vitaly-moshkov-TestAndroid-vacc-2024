package com.example.foodapp.root.domain.usecases

import com.example.foodapp.root.domain.models.FoodDetailUI
import com.example.foodapp.root.domain.respository.FoodRepository
import com.example.foodapp.root.platform.BaseUseCase
import com.example.foodapp.root.platform.Either
import com.example.foodapp.root.platform.Failure
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