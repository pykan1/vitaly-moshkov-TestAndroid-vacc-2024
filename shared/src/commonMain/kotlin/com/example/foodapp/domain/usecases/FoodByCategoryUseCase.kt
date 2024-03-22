package com.example.foodapp.domain.usecases

import com.example.foodapp.domain.models.FoodUI
import com.example.foodapp.domain.respository.FoodRepository
import com.example.foodapp.platform.BaseUseCase
import com.example.foodapp.platform.Either
import com.example.foodapp.platform.Failure
import kotlinx.coroutines.CoroutineScope

class FoodByCategoryUseCase(private val foodRepository: FoodRepository):
    BaseUseCase<FoodByCategoryUseCase.Params, List<FoodUI>>() {
    class Params(val category: String)

    override suspend fun execute(
        params: Params,
        scope: CoroutineScope
    ): Either<Failure, List<FoodUI>> {
        return foodRepository.getFoodsByCategory(params.category)
    }

}