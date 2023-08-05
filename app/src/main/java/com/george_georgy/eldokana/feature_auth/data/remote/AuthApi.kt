package com.george_georgy.eldokana.feature_auth.data.remote

import com.george_georgy.eldokana.feature_auth.data.dto.UserDto
import com.george_georgy.eldokana.feature_auth.data.remote.request.LoginRequest
import com.george_georgy.eldokana.feature_auth.data.remote.response.LoginResponse


interface AuthApi {

    suspend fun loginUser(
         loginRequest: LoginRequest
    ): LoginResponse

    suspend fun getAllUsers(): List<UserDto>

}