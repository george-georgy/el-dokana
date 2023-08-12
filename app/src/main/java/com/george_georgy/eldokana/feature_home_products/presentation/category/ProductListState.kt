package com.george_georgy.eldokana.feature_home_products.presentation.category

import com.george_georgy.eldokana.feature_home_products.domain.model.Product


data class ProductListState(
    val isLoading : Boolean = false,
    val products : List<Product> = emptyList(),
    val error : String = ""
)