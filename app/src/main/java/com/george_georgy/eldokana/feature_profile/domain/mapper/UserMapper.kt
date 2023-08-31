package com.george_georgy.eldokana.feature_profile.domain.mapper

import com.george_georgy.eldokana.feature_auth.data.dto.UserDto
import com.george_georgy.eldokana.feature_profile.domain.model.User

internal fun UserDto.toUser(): User {
    return User(
        address = address,
        email = email,
        id = id,
        name = name,
        password = password,
        phone = phone,
        username = username
    )
}