package com.example.foodapp.root.domain.usecases

import com.example.foodapp.root.domain.models.CategoryUI
import com.example.foodapp.root.domain.respository.FoodRepository
import com.example.foodapp.root.platform.BaseUseCase
import com.example.foodapp.root.platform.Either
import com.example.foodapp.root.platform.Failure
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