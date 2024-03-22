package com.example.foodapp.domain.usecases

import com.example.foodapp.domain.models.CategoryUI
import com.example.foodapp.domain.respository.FoodRepository
import com.example.foodapp.platform.BaseUseCase
import com.example.foodapp.platform.Either
import com.example.foodapp.platform.Failure
import kotlinx.coroutines.CoroutineScope

class GetAllCategoriesUseCase(private val foodRepository: FoodRepository):
    BaseUseCase<GetAllCategoriesUseCase.Params, List<CategoryUI>>() {

    class Params

    override suspend fun execute(
        params: Params,
        scope: CoroutineScope
    ): Either<Failure, List<CategoryUI>> {
        return foodRepository.allCategories()
    }

}