package com.george_georgy.eldokana.feature_wishlist.domain.model

import com.george_georgy.eldokana.feature_home_products.domain.model.Rating

data class Wish(
    val image: String,
    val price: Double,
    val title: String,
    val category: String,
    val description: String,
    val rating: Rating,
    val id: Int,
    val liked: Boolean = false,
)
