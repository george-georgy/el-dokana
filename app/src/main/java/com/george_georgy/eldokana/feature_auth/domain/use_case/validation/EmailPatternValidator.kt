package com.george_georgy.eldokana.feature_auth.domain.use_case.validation

interface EmailPatternValidator {
    fun isValidEmail(email : String) : Boolean
}