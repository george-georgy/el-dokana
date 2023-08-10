package com.george_georgy.eldokana.feature_home_products.domain.use_case

import com.george_georgy.eldokana.core.utils.Resource
import com.george_georgy.eldokana.feature_home_products.domain.model.Product
import com.george_georgy.eldokana.feature_home_products.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow

class GetProductsUseCase(
    private val productsRepo: HomeRepository,

) {

    operator fun invoke():
            Flow<Resource<List<Product>>> {
        return productsRepo.getProducts()
    }
}