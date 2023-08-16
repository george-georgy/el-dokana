package com.george_georgy.eldokana.feature_wishlist.data.util

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.george_georgy.eldokana.feature_home_products.domain.model.Rating
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class Converters(
    private val gson: Gson
) {

    @TypeConverter
    fun fromRating(rating: Rating): String {
        return gson.toJson(rating)
    }

    @TypeConverter
    fun toRating(ratingString: String): Rating {
        val type = object : TypeToken<Rating>() {}.type
        return gson.fromJson(ratingString, type)
    }
}
