package com.george_georgy.eldokana.feature_auth.domain.use_case.validation

import com.george_georgy.eldokana.feature_auth.domain.utils.ValidationResult

class ValidateNameUseCase {

    fun execute(
        name: String
    ): ValidationResult {
        if (name.isEmpty()) {
            return ValidationResult(
                successful = false,
                errorMessage = "Hold up, this field is required"
            )
        }
        return ValidationResult(
            successful = true,
        )

    }


}