package com.george_georgy.eldokana.feature_home_products.data.remote

import com.george_georgy.eldokana.core.utils.Constants
import com.george_georgy.eldokana.feature_home_products.data.remote.dto.ProductDto
import io.ktor.client.HttpClient
import io.ktor.client.features.ClientRequestException
import io.ktor.client.features.RedirectResponseException
import io.ktor.client.features.ServerResponseException
import io.ktor.client.request.*

class HomeApiImpl(
    private val client: HttpClient
) : HomeApi {
    override suspend fun getAllProducts(): List<ProductDto> {

        return client.get { url("${Constants.BASE_URL}products") }

    }

    override suspend fun getProductCategories(): List<String> {
        return client.get { url("${Constants.BASE_URL}products/categories") }

    }


}
