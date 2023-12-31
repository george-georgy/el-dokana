package com.george_georgy.eldokana.feature_auth.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class Address(
    val city: String,
    val geolocation: Geolocation,
    val number: Int,
    val street: String,
    val zipcode: String
)