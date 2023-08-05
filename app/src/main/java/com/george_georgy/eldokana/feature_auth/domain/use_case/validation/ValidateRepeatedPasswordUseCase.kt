package com.george_georgy.eldokana.feature_auth.domain.use_case.validation

import com.george_georgy.eldokana.feature_auth.domain.utils.ValidationResult

class ValidateRepeatedPasswordUseCase {

    fun execute(
        password: String ,
        repeatedPassword: String
    ): ValidationResult {

        if (password != repeatedPassword) {
            return ValidationResult(
                successful = false,
                errorMessage = "The Password don't match"
            )
        }

        return ValidationResult(
            successful = true,
        )

    }


}