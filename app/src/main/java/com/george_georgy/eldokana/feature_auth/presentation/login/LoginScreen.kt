package com.george_georgy.eldokana.feature_auth.presentation.login

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.george_georgy.eldokana.R
import com.george_georgy.eldokana.core.presentation.ui.theme.Black
import com.george_georgy.eldokana.feature_auth.presentation.components.AuthButton
import com.george_georgy.eldokana.feature_auth.presentation.components.AuthPasswordTextField
import com.george_georgy.eldokana.feature_auth.presentation.components.AuthTextField
import com.george_georgy.eldokana.feature_auth.presentation.components.ClickableAuthText
import com.george_georgy.eldokana.feature_auth.presentation.components.DividerTextComponent
import com.george_georgy.eldokana.feature_auth.presentation.components.HeadingTextComponent
import com.george_georgy.eldokana.feature_auth.util.AuthResult
import org.koin.androidx.compose.getViewModel

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    onNavigationSignUpScreen: () -> Unit,
    onNavigationForgetPassword: () -> Unit,
    loginViewModel: LoginViewModel = getViewModel(),

    ) {


    val state = loginViewModel.state
    val context = LocalContext.current
    val uiColor = if (isSystemInDarkTheme()) White else Black



    LaunchedEffect(key1 = context) {
        loginViewModel.authResultEventChannel.collect { event ->
            when (event) {
                is AuthResult.Authorized -> {
                    onLoginSuccess()
                    Toast.makeText(
                        context, R.string.you_are_now_logged_in, Toast.LENGTH_LONG
                    ).show()
                }

                is AuthResult.Unauthorized -> {
                    Toast.makeText(
                        context,
                        "You're not authorized",
                        Toast.LENGTH_LONG
                    ).show()
                }
                is AuthResult.UnknownError -> {
                    Toast.makeText(
                        context,
                        "An unknown error occurred",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(28.dp),
            verticalArrangement = Arrangement.Center
        ) {


            HeadingTextComponent(
                value = stringResource(R.string.login_to_your_account),
            )


            Spacer(modifier = Modifier.height(60.dp))


            AuthTextField(
                modifier = Modifier.fillMaxWidth(),

                label = stringResource(R.string.username),
                value = state.username,
                onValueChange = {
                    loginViewModel.onFormEvent(LoginFormEvent.UsernameChanged(it))
                },
                errorValue = state.usernameError,
                isError = state.usernameError != null,
                imageVector = Icons.Default.Email,
            )



            AuthPasswordTextField(
                modifier = Modifier.fillMaxWidth(),

                label = stringResource(R.string.password),
                value = state.password,
                onValueChange = {
                    loginViewModel.onFormEvent(LoginFormEvent.PasswordChanged(it))
                },
                errorValue = state.passwordError,
                isError = state.passwordError != null,
                imageVector = Icons.Default.Lock,

                )



            Text(
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 8.dp)
                    .clickable{
                        onNavigationForgetPassword()
                    },
                text = stringResource(R.string.forgot_your_password),
                color = uiColor,
                fontWeight = FontWeight.Bold
            )


            AuthButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 8.dp),
                text = stringResource(R.string.login),
                contentColor = White,
            ) {
                loginViewModel.onFormEvent(LoginFormEvent.Login)
            }


            DividerTextComponent()

            ClickableAuthText(
                initialText = stringResource(R.string.don_t_have_an_account),
                clickableText = stringResource(R.string.create_new)
            ) {
                onNavigationSignUpScreen()
            }


        }

            if (state.isLoading) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(if (isSystemInDarkTheme()) Black  else White),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
        }

    }
