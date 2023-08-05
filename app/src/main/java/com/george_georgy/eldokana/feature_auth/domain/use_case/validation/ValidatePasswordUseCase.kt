package com.george_georgy.eldokana.feature_auth.domain.use_case.validation

import com.george_georgy.eldokana.feature_auth.domain.utils.ValidationResult

class ValidatePasswordUseCase {

    fun execute(
        password: String
    ): ValidationResult {

        if (password.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "Hold up, this field is required"
            )
        }

        if (password.length < 6) {
            return ValidationResult(
                successful = false,
                errorMessage = "The Password needs to consist at least 6 character"
            )
        }

        val containsLetterAndDigits = password.any{ it.isDigit()} && password.any{it.isLetter()}

        if (!containsLetterAndDigits) {
            return ValidationResult(
                successful = false,
                errorMessage = "The password needs to contain at least one letter and digit"
            )

        }
        return ValidationResult(
            successful = true,
        )

    }


}