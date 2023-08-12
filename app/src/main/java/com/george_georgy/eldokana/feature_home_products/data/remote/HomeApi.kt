package com.george_georgy.eldokana.feature_home_products.data.remote

import com.george_georgy.eldokana.feature_home_products.data.remote.dto.ProductDto

interface HomeApi {

    suspend fun getAllProducts():
            List<ProductDto>

    suspend fun getProductCategories():
            List<String>


}