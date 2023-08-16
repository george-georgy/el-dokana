package com.george_georgy.eldokana.feature_wishlist.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.george_georgy.eldokana.feature_home_products.domain.model.Rating
import com.george_georgy.eldokana.feature_wishlist.util.Constant.WISHLIST_TABLE_NAME

@Entity(tableName = WISHLIST_TABLE_NAME)
data class WishlistEntity(
    val image: String,
    val price: Double,
    val title: String,
    val category: String,
    val description: String,
    val rating: Rating,
    val liked: Boolean = false,
    @PrimaryKey (autoGenerate = false)
    val id: Int,
)

