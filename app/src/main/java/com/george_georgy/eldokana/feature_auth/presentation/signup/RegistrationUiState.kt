package com.george_georgy.eldokana.feature_auth.presentation.signup


data class RegistrationUiState(

    val isLoading: Boolean = false,

    val name : String = "",
    val nameError : String? = null,

    val email : String = "",
    val emailError : String? = null,

    val password : String = "",
    val passwordError : String? = null,

    val repeatedPassword : String = "",
    val repeatedPasswordError : String? = null,


    )