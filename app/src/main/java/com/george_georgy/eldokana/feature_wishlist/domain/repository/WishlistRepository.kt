package com.george_georgy.eldokana.feature_wishlist.domain.repository

import androidx.lifecycle.LiveData
import com.george_georgy.eldokana.feature_wishlist.data.local.entity.WishlistEntity
import com.george_georgy.eldokana.feature_wishlist.domain.model.Wish
import kotlinx.coroutines.flow.Flow

interface WishlistRepository {

    suspend fun insertWishItem(wish: Wish)


    fun getWishlist(): Flow<List<WishlistEntity>>


    fun getWishItem(id: Int): Flow<WishlistEntity?>


    suspend fun deleteWishItem(wish: Wish)


    suspend fun deleteWishlist()


    fun isInWishlist(id: Int): LiveData<Boolean>

}