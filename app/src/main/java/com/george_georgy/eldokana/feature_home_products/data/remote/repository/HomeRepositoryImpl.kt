package com.george_georgy.eldokana.feature_home_products.data.remote.repository

import com.bumptech.glide.load.HttpException
import com.george_georgy.eldokana.core.utils.Resource
import com.george_georgy.eldokana.feature_home_products.data.remote.HomeApi
import com.george_georgy.eldokana.feature_home_products.data.remote.mappers.toProduct
import com.george_georgy.eldokana.feature_home_products.domain.model.Product
import com.george_georgy.eldokana.feature_home_products.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import java.io.IOException

class HomeRepositoryImpl(
    private val homeApi : HomeApi

) : HomeRepository {
    override fun getProducts(): Flow<Resource<List<Product>>> = flow {
        try {
            emit(Resource.Loading())
            val response = homeApi.getAllProducts()
            emit(Resource.Success(response.map { it.toProduct() }))
        } catch (e: IOException) {
            emit(Resource.Error(message = "Could not reach the server, please check your internet connection!"))
        } catch (e: HttpException) {
            emit(Resource.Error(message = "Oops, something went wrong!"))
        }
    }

    override suspend fun getProductCategories(): List<String> =
         homeApi.getProductCategories()



}


