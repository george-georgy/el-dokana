package com.george_georgy.eldokana.feature_auth.presentation.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.george_georgy.eldokana.feature_auth.domain.use_case.signing.LoginUseCase
import com.george_georgy.eldokana.feature_auth.domain.use_case.validation.ValidationUseCases
import com.george_georgy.eldokana.feature_auth.util.AuthResult
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import timber.log.Timber


class LoginViewModel(
    private val validationUseCases: ValidationUseCases,
    private val loginUseCase: LoginUseCase

) : ViewModel() {

    // state of Login form (state that passed to ui)
    var state by mutableStateOf(LoginUiState())
        private set

    // result events from viewModel to ui
    private val _authResultEventChannel = Channel<AuthResult<Unit>>()
    val authResultEventChannel = _authResultEventChannel.receiveAsFlow()

    // events from ui to viewModel (email,pass text fields changes and login button)
    fun onFormEvent(event: LoginFormEvent) {
        when (event) {
            is LoginFormEvent.UsernameChanged -> {
                state = state.copy(username = event.userName)
            }

            is LoginFormEvent.PasswordChanged -> {
                state = state.copy(password = event.password)
            }

            is LoginFormEvent.Login -> {
                login()
            }
        }
    }


    private fun loginValidation() : Boolean{

        // checking validation
        val usernameResult = validationUseCases.validateNameUseCase.execute(state.username)
        val passwordResult = validationUseCases.validatePasswordUseCase.execute(state.password)


        val hasError = listOf(
            usernameResult,
            passwordResult,
        ).any { !it.successful }

        state = state.copy(
            usernameError = usernameResult.errorMessage,
            passwordError = passwordResult.errorMessage,
        )
        return hasError
    }

    private fun login() {

        val hasError = loginValidation()

        if (hasError) {
            return
        }

        // if the validation is Succeeded, login
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            val result = loginUseCase(
                username = state.username,
                password = state.password
            )
            _authResultEventChannel.send(result)
            state = state.copy(isLoading = false)
        }



    }






}