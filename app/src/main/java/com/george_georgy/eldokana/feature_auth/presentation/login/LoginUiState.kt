package com.george_georgy.eldokana.feature_auth.presentation.login

data class LoginUiState(

    val isLoading: Boolean = false,

    val username : String = "mor_2314",
    val usernameError : String? = null,

    val password : String = "83r5^_",
    val passwordError : String? = null,

    )