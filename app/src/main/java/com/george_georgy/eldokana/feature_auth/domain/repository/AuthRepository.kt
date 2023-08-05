package com.george_georgy.eldokana.feature_auth.domain.repository

import com.george_georgy.eldokana.core.utils.Resource
import com.george_georgy.eldokana.feature_auth.util.AuthResult

interface AuthRepository {


    suspend fun loginUser(
        username : String,
        password: String
    ): AuthResult<Unit>

    suspend fun autoLogin()
    : Resource<Unit>

    suspend fun logout()
    : Resource<Unit>

}