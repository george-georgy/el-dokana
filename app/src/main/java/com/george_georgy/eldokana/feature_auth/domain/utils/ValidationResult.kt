package com.george_georgy.eldokana.feature_auth.domain.utils

data class ValidationResult(
    val successful : Boolean,
    val errorMessage : String? = null
)