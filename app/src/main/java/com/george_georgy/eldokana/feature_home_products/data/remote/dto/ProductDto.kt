package com.george_georgy.eldokana.feature_home_products.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class ProductDto(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: RatingDto,
    val title: String
)