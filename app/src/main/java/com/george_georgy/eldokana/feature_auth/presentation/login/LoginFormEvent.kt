package com.george_georgy.eldokana.feature_auth.presentation.login

sealed class LoginFormEvent {

    data class UsernameChanged(val userName : String) : LoginFormEvent()
    data class PasswordChanged(val password : String) : LoginFormEvent()

    object Login : LoginFormEvent()

}