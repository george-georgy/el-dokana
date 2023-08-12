package com.george_georgy.eldokana.feature_auth.domain.use_case.signing

import com.george_georgy.eldokana.feature_auth.domain.repository.AuthRepository
import com.george_georgy.eldokana.feature_auth.util.AuthResult

class LoginUseCase(
    private val authRepository: AuthRepository
) {

     suspend operator fun invoke(
        username: String,
        password: String
    ): AuthResult<Unit> {
        return authRepository
            .loginUser(username = username, password = password)
    }
}