package com.george_georgy.eldokana.feature_wishlist.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.george_georgy.eldokana.feature_wishlist.data.local.entity.WishlistEntity
import com.george_georgy.eldokana.feature_wishlist.data.util.Converters

@TypeConverters(Converters::class)
@Database(entities = [WishlistEntity::class], version = 2, exportSchema = false)

abstract class WishlistDatabase : RoomDatabase() {

    abstract val wishlistDao: WishlistDao
}