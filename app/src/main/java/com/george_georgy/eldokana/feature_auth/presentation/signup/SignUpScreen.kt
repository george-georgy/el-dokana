package com.george_georgy.eldokana.feature_auth.presentation.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.george_georgy.eldokana.R
import com.george_georgy.eldokana.feature_auth.presentation.components.AuthButton
import com.george_georgy.eldokana.feature_auth.presentation.components.AuthPasswordTextField
import com.george_georgy.eldokana.feature_auth.presentation.components.AuthTextField
import com.george_georgy.eldokana.feature_auth.presentation.components.ClickableAuthText
import com.george_georgy.eldokana.feature_auth.presentation.components.DividerTextComponent
import com.george_georgy.eldokana.feature_auth.presentation.components.ErrorAuthBox
import com.george_georgy.eldokana.feature_auth.presentation.components.HeadingTextComponent
import org.koin.androidx.compose.getViewModel

@Composable
fun SignUpScreen(
    onSignUpSuccess: () -> Unit,
    onNavigationLoginScreen: () -> Unit,
    viewModel: SignUpViewModel = getViewModel()
) {


    val state = viewModel.state
    val context = LocalContext.current

    LaunchedEffect(key1 = context) {
        /*
        viewModel.authEvent.collect { event ->
            when (event) {
                is AuthResult. -> {
                    onSignUpSuccess()
                    Toast.makeText(
                        context,
                        "Registration successful",
                        Toast.LENGTH_LONG
                    ).show()
                }

                is AuthResult.Loading -> {
                    Toast.makeText(
                        context,
                        "Loading",
                        Toast.LENGTH_LONG
                    ).show()
                }

                else -> {
                    Toast.makeText(
                        context,
                        "" +
                                "Email already exists",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

         */
    }
    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(28.dp),
            verticalArrangement = Arrangement.Center
        ) {


            HeadingTextComponent(
                stringResource(R.string.create_an_account),
            )

            Spacer(modifier = Modifier.height(60.dp))

            AuthTextField(

                label = stringResource(id = R.string.username),
                value = state.name,
                onValueChange = { name ->
                    viewModel.onFormEvent(RegistrationFormEvent.UsernameChanged(name))
                },
                imageVector = Icons.Default.Person,
                isError = state.nameError != null,
            )

            ErrorAuthBox(
                error = state.nameError
            )


            AuthTextField(
                label = stringResource(R.string.email),
                value = state.email,
                onValueChange = { email ->
                    viewModel.onFormEvent(RegistrationFormEvent.EmailChanged(email))
                },
                imageVector = Icons.Default.Email,
                isError = state.emailError != null,
            )

            ErrorAuthBox(
                error = state.emailError
            )

            AuthPasswordTextField(
                label = stringResource(id = R.string.password),
                value = state.password,
                onValueChange = { password ->
                    viewModel.onFormEvent(RegistrationFormEvent.PasswordChanged(password))
                },
                imageVector = Icons.Default.Lock,
                isError = state.passwordError != null,
            )

            ErrorAuthBox(
                error = state.passwordError
            )

            AuthPasswordTextField(

                label = stringResource(R.string.repeat_password),
                value = state.repeatedPassword,
                onValueChange = { repeatedPassword ->
                    viewModel.onFormEvent(
                        RegistrationFormEvent.RepeatedPasswordChanged(
                            repeatedPassword
                        )
                    )
                },
                imageVector = Icons.Default.Lock,
                isError = state.repeatedPasswordError != null,

                )

            ErrorAuthBox(
                error = state.repeatedPasswordError
            )

            Spacer(modifier = Modifier.height(20.dp))

            AuthButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 8.dp),
                text = stringResource(R.string.sign_up),
                contentColor = Color.White,
            ) {
                viewModel.onFormEvent(RegistrationFormEvent.SignUp)
            }

            DividerTextComponent()

            ClickableAuthText(
                initialText = stringResource(R.string.have_an_account),
                clickableText = stringResource(R.string.login)
            ) {
                onNavigationLoginScreen()
            }

            if (state.isLoading) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }


        }
    }
}
