package com.george_georgy.eldokana.feature_home_products.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class RatingDto(
    val count: Int,
    val rate: Double
)