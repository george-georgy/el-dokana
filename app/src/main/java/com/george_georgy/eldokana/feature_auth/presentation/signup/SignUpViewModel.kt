package com.george_georgy.eldokana.feature_auth.presentation.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.george_georgy.eldokana.feature_auth.domain.use_case.validation.ValidationUseCases
import com.george_georgy.eldokana.feature_auth.util.AuthResult
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

// vm will mke use of usecase and map the result to compose state
class SignUpViewModel(

    private val validationUseCases: ValidationUseCases,
//    private val signUpUseCase: SignUpUseCase


) : ViewModel() {

    // state of registration form
    var state by mutableStateOf(RegistrationUiState())
        private set

    // result events from viewModel to ui
    private val _authResultEventChannel = Channel<AuthResult<Unit>>()
    val authEvent = _authResultEventChannel.receiveAsFlow()

    // events from ui to viewModel (email,pass,repeated pass text field changes and signup button)
    fun onFormEvent(event: RegistrationFormEvent) {
        when (event) {

            is RegistrationFormEvent.UsernameChanged -> {
                state = state.copy(name = event.username)
                state =
                    state.copy(nameError = validationUseCases.validateNameUseCase.execute(state.name).errorMessage)

            }

            is RegistrationFormEvent.EmailChanged -> {
                state = state.copy(email = event.email)
                state =
                    state.copy(emailError = validationUseCases.validateEmailUseCase.execute(state.email).errorMessage)

            }

            is RegistrationFormEvent.PasswordChanged -> {
                state = state.copy(password = event.password)
                state = state.copy(
                    passwordError = validationUseCases.validatePasswordUseCase.execute(state.password).errorMessage
                )
            }

            is RegistrationFormEvent.RepeatedPasswordChanged -> {
                state = state.copy(repeatedPassword = event.repeatedPassword)
                state = state.copy(
                    repeatedPasswordError = validationUseCases.validateRepeatedPasswordUseCase.execute(
                        state.password, state.repeatedPassword).errorMessage
                )
            }

            is RegistrationFormEvent.SignUp -> {
                signUp()
            }
        }
    }


    private fun signUpValidation(): Boolean {

        // checking validation
        val nameResult = validationUseCases.validateNameUseCase.execute(state.name)
        val emailResult = validationUseCases.validateEmailUseCase.execute(state.email)
        val passwordResult = validationUseCases.validatePasswordUseCase.execute(state.password)
        val repeatedPasswordResult = validationUseCases.validateRepeatedPasswordUseCase.execute(
            state.password, state.repeatedPassword
        )

        val hasError = listOf(
            nameResult,
            emailResult,
            passwordResult,
            repeatedPasswordResult
        ).any { !it.successful }

        state = state.copy(
            nameError = nameResult.errorMessage,
            emailError = emailResult.errorMessage,
            passwordError = passwordResult.errorMessage,
            repeatedPasswordError = repeatedPasswordResult.errorMessage,
        )
        return hasError
    }

    private fun signUp() {

        val hasError = signUpValidation()

        if (hasError) {
            return
        }
/*
        // if the validation is Succeeded, login
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            val result = SignUsecase(
                username = state.username,
                password = state.password
            )
            _authResultEventChannel.send(result)
            state = state.copy(isLoading = false)

 */
        }

    }


