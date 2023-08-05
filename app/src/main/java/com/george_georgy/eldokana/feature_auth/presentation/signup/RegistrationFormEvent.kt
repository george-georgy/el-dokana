package com.george_georgy.eldokana.feature_auth.presentation.signup

// ui event that user can perform
sealed class RegistrationFormEvent {

    data class UsernameChanged(val username : String) : RegistrationFormEvent()
    data class EmailChanged(val email : String) : RegistrationFormEvent()
    data class PasswordChanged(val password : String) : RegistrationFormEvent()
    data class RepeatedPasswordChanged(val repeatedPassword : String) : RegistrationFormEvent()

    object SignUp : RegistrationFormEvent()

}