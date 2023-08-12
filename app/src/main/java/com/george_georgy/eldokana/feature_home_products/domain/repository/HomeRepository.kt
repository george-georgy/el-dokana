package com.george_georgy.eldokana.feature_home_products.domain.repository


import com.george_georgy.eldokana.core.utils.Resource
import com.george_georgy.eldokana.feature_home_products.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface HomeRepository {

     fun getProducts():
            Flow<Resource<List<Product>>>

     suspend fun getProductCategories():
            List<String>
}