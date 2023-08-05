package com.george_georgy.eldokana.feature_auth.domain.use_case.signing

import com.george_georgy.eldokana.core.utils.Resource
import com.george_georgy.eldokana.feature_auth.domain.repository.AuthRepository


class LogoutUseCase(
    private val loginRepository: AuthRepository
) {
    suspend operator fun invoke()
    : Resource<Unit> {
        return loginRepository.logout()
    }
}
