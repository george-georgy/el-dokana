package com.george_georgy.eldokana.feature_wishlist.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.george_georgy.eldokana.feature_wishlist.data.local.entity.WishlistEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WishlistDao {

    @Insert
    suspend fun insertWishItem(wishlistEntity: WishlistEntity)

    @Query("SELECT * FROM wishlist_table ORDER BY id DESC")
    fun getWishlist(): Flow<List<WishlistEntity>>

    @Query("SELECT * FROM wishlist_table WHERE id  == :id")
    fun getWishItem(id: Int): Flow<WishlistEntity?>

    @Delete
    suspend fun deleteWishItem(wishlistEntity: WishlistEntity)

    @Query("DELETE FROM wishlist_table")
    suspend fun deleteWishlist()

    @Query("SELECT liked FROM wishlist_table WHERE id = :id")
    fun isInWishlist(id: Int): LiveData<Boolean>

}