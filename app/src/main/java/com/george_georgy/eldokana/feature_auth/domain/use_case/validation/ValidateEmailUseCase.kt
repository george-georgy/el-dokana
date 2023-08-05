package com.george_georgy.eldokana.feature_auth.domain.use_case.validation

import com.george_georgy.eldokana.feature_auth.domain.utils.ValidationResult

class ValidateEmailUseCase(
    private val validator: EmailPatternValidator
) {

    fun execute(
        email: String
    ): ValidationResult {
        if (email.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "Hold up, this field is required"
            )
        }
        if (!validator.isValidEmail(email)) {
            return ValidationResult(
                successful = false,
                errorMessage = "Oh no! Please enter a valid email"
            )

        }
        return ValidationResult(
            successful = true,
        )

    }


}