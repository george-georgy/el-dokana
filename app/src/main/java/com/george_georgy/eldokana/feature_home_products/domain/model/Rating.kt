package com.george_georgy.eldokana.feature_home_products.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Rating(
    val count: Int,
    val rate: Double
) : Parcelable
