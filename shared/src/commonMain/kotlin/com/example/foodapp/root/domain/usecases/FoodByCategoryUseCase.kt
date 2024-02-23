package com.example.foodapp.root.domain.usecases

import com.example.foodapp.root.domain.models.FoodUI
import com.example.foodapp.root.domain.respository.FoodRepository
import com.example.foodapp.root.platform.BaseUseCase
import com.example.foodapp.root.platform.Either
import com.example.foodapp.root.platform.Failure
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