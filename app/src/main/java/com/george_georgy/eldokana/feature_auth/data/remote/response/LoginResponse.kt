package com.george_georgy.eldokana.feature_auth.data.remote.response


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    @SerializedName("token")
    val token: String
)