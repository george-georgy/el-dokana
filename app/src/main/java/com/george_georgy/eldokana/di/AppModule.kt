package com.george_georgy.eldokana.di

import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.preferencesDataStoreFile
import com.george_georgy.eldokana.feature_auth.data.local.UserPreference
import com.george_georgy.eldokana.feature_auth.data.remote.AuthApi
import com.george_georgy.eldokana.feature_auth.data.remote.AuthImpl
import com.george_georgy.eldokana.feature_auth.data.repository.AuthRepositoryImpl
import com.george_georgy.eldokana.feature_auth.domain.repository.AuthRepository
import com.george_georgy.eldokana.feature_auth.domain.use_case.signing.AutoLoginUseCase
import com.george_georgy.eldokana.feature_auth.domain.use_case.signing.LoginUseCase
import com.george_georgy.eldokana.feature_auth.domain.use_case.signing.LogoutUseCase
import com.george_georgy.eldokana.feature_auth.domain.use_case.validation.EmailPatternValidator
import com.george_georgy.eldokana.feature_auth.domain.use_case.validation.EmailPatternValidatorImpl
import com.george_georgy.eldokana.feature_auth.domain.use_case.validation.ValidateEmailUseCase
import com.george_georgy.eldokana.feature_auth.domain.use_case.validation.ValidateNameUseCase
import com.george_georgy.eldokana.feature_auth.domain.use_case.validation.ValidatePasswordUseCase
import com.george_georgy.eldokana.feature_auth.domain.use_case.validation.ValidateRepeatedPasswordUseCase
import com.george_georgy.eldokana.feature_auth.domain.use_case.validation.ValidationUseCases
import com.george_georgy.eldokana.feature_auth.presentation.login.LoginViewModel
import com.george_georgy.eldokana.feature_auth.presentation.signup.SignUpViewModel
import com.george_georgy.eldokana.feature_auth.presentation.splash.SplashViewModel
import com.george_georgy.eldokana.feature_auth.util.Constants.AUTH_PREFERENCES
import com.google.gson.Gson
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logging
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

// HttpClient instance
    single{
        HttpClient(Android){
            install(Logging){
                level = LogLevel.ALL
            }
            install(JsonFeature){
                serializer = KotlinxSerializer()
            }
        }
    }
// AuthApi instance
    single<AuthApi>{
        AuthImpl(get())
    }

// dataStore instance
    single{
        PreferenceDataStoreFactory.create(
            produceFile = {
                androidContext().preferencesDataStoreFile(AUTH_PREFERENCES)
            }
        )
    }

// Gson instance
    single {
        Gson()
    }

// UserPreference instance
    single {
        UserPreference(get(),get())

    }

// AuthRepositoryImpl Repository instance
    single<AuthRepository> {
        AuthRepositoryImpl(get(),get())
    }

// LoginUseCase  instance
    single {
        LoginUseCase(get())
    }

// AutoLoginUseCase instance
    single {
        AutoLoginUseCase(get())
    }

// LogoutUseCase instance
    single {
        LogoutUseCase(get())
    }
// LogoutUseCase instance
    single<EmailPatternValidator> {
        EmailPatternValidatorImpl()
    }

// ValidationUseCases  instance
    single {
        ValidationUseCases(
            validateNameUseCase = ValidateNameUseCase(),
            validateEmailUseCase = ValidateEmailUseCase(get()),
            validatePasswordUseCase = ValidatePasswordUseCase(),
            validateRepeatedPasswordUseCase = ValidateRepeatedPasswordUseCase(),

            )
    }

// LoginViewModel instance
    viewModel {
        LoginViewModel(get(),get())
    }

// SignUpViewModel instance
    viewModel {
        SignUpViewModel(get())
    }

// SplashViewModel instance
    viewModel {
        SplashViewModel(get())
    }



}