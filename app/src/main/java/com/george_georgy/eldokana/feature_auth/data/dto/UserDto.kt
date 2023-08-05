package com.george_georgy.eldokana.feature_auth.data.dto

import com.george_georgy.eldokana.feature_auth.data.dto.Address
import com.george_georgy.eldokana.feature_auth.data.dto.Name

data class UserDto(
    val __v: Int,
    val address: Address,
    val email: String,
    val id: Int,
    val name: Name,
    val password: String,
    val phone: String,
    val username: String
)