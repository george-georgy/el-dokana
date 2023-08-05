package com.george_georgy.eldokana.feature_auth.domain.use_case.validation

import com.george_georgy.eldokana.feature_auth.domain.use_case.validation.ValidateEmailUseCase
import com.george_georgy.eldokana.feature_auth.domain.use_case.validation.ValidateNameUseCase
import com.george_georgy.eldokana.feature_auth.domain.use_case.validation.ValidatePasswordUseCase
import com.george_georgy.eldokana.feature_auth.domain.use_case.validation.ValidateRepeatedPasswordUseCase

data class ValidationUseCases(
    val validateNameUseCase: ValidateNameUseCase,
    val validateEmailUseCase: ValidateEmailUseCase,
    val validatePasswordUseCase: ValidatePasswordUseCase,
    val validateRepeatedPasswordUseCase: ValidateRepeatedPasswordUseCase,
)


