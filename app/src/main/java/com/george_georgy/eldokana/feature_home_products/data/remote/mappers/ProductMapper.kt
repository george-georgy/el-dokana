package com.george_georgy.eldokana.feature_home_products.data.remote.mappers

import com.george_georgy.eldokana.feature_home_products.data.remote.dto.ProductDto
import com.george_georgy.eldokana.feature_home_products.data.remote.dto.RatingDto
import com.george_georgy.eldokana.feature_home_products.domain.model.Product
import com.george_georgy.eldokana.feature_home_products.domain.model.Rating


internal fun ProductDto.toProduct(): Product {

    return Product(
        category = category,
        description = description,
        id = id,
        image = image,
        price = price,
        rating = rating.toRating(),
        title = title
    )
}

internal fun RatingDto.toRating(): Rating {
    return Rating(
        count = count,
        rate = rate
    )
}