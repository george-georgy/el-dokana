package com.george_georgy.eldokana.feature_wishlist.data.mapper

import com.george_georgy.eldokana.feature_home_products.domain.model.Product
import com.george_georgy.eldokana.feature_wishlist.data.local.entity.WishlistEntity
import com.george_georgy.eldokana.feature_wishlist.domain.model.Wish


fun WishlistEntity.toWish(): Wish {
    return Wish(
        image = image,
        price = price,
        title = title,
        category = category,
        description = description,
        rating = rating,
        liked = liked,
        id = id,
        )
}

fun Wish.toWishlistEntity(): WishlistEntity {
    return WishlistEntity(
        image = image,
        price = price,
        title = title,
        category = category,
        description = description,
        rating = rating,
        liked = liked,
        id = id,
    )
}

internal fun Wish.toProduct(): Product {
    return Product(
        image = image,
        price = price,
        title = title,
        id = id,
        category = category,
        description = description,
        rating = rating,
    )
}

internal fun Product.toWish(): Wish {
    return Wish(
        image = image,
        price = price,
        title = title,
        id = id,
        category = category,
        description = description,
        rating = rating,
    )
}