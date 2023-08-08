package com.george_georgy.eldokana.feature_home_products.domain.use_case

import com.george_georgy.eldokana.feature_home_products.domain.repository.HomeRepository

class GetCategoriesUseCase(
    private val homeRepository: HomeRepository
) {
    suspend operator fun invoke(): List<String> {

        val categories = homeRepository.getProductCategories()
        return listOf("All") + categories

    }
}