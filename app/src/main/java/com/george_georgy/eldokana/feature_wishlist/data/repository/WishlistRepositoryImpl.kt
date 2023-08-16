package com.george_georgy.eldokana.feature_wishlist.data.repository

import androidx.lifecycle.LiveData
import com.george_georgy.eldokana.feature_wishlist.data.local.WishlistDatabase
import com.george_georgy.eldokana.feature_wishlist.data.local.entity.WishlistEntity
import com.george_georgy.eldokana.feature_wishlist.data.mapper.toWishlistEntity
import com.george_georgy.eldokana.feature_wishlist.domain.model.Wish
import com.george_georgy.eldokana.feature_wishlist.domain.repository.WishlistRepository
import kotlinx.coroutines.flow.Flow

class WishlistRepositoryImpl(
    private val db: WishlistDatabase
) : WishlistRepository {
    override suspend fun insertWishItem(wish: Wish) {
        db.wishlistDao.insertWishItem(wish.toWishlistEntity())
    }

    override fun getWishlist(): Flow<List<WishlistEntity>> {
        return db.wishlistDao.getWishlist()
    }

    override fun getWishItem(id: Int): Flow<WishlistEntity?> {
        return db.wishlistDao.getWishItem(id = id)
    }

    override suspend fun deleteWishItem(wish: Wish) {
        db.wishlistDao.deleteWishItem(wish.toWishlistEntity())
    }

    override suspend fun deleteWishlist() {
        db.wishlistDao.deleteWishlist()
    }

    override fun isInWishlist(id: Int): LiveData<Boolean> {
        return db.wishlistDao.isInWishlist(id = id)
    }

}