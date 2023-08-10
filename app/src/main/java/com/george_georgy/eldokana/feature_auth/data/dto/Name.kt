package com.george_georgy.eldokana.feature_auth.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class Name(
    val firstname: String,
    val lastname: String
)