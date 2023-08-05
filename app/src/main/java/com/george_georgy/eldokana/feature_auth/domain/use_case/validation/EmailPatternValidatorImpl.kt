package com.george_georgy.eldokana.feature_auth.domain.use_case.validation

import androidx.core.util.PatternsCompat
import com.george_georgy.eldokana.feature_auth.domain.use_case.validation.EmailPatternValidator

class EmailPatternValidatorImpl : EmailPatternValidator {
    override fun isValidEmail(email: String): Boolean {
        return PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()
    }
}