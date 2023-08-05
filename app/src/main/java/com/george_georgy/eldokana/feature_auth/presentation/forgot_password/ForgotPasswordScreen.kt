package com.george_georgy.eldokana.feature_auth.presentation.forgot_password

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.george_georgy.eldokana.feature_auth.presentation.components.AuthButton
import com.george_georgy.eldokana.feature_auth.presentation.components.AuthTextField
import com.george_georgy.eldokana.feature_auth.presentation.components.ClickableAuthText
import com.george_georgy.eldokana.feature_auth.presentation.components.HeadingTextComponent
import com.george_georgy.eldokana.feature_auth.presentation.components.NormalTextComponent
import com.george_georgy.eldokana.R


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ForgotPasswordScreen(
    onNavigationSignUpScreen: () -> Unit,
) {
    val context = LocalContext.current

    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(28.dp),
        ) {

            Spacer(modifier = Modifier.height(40.dp))


            HeadingTextComponent(
                value = stringResource(id = R.string.forgot_your_password),
            )
            Spacer(modifier = Modifier.height(40.dp))

            NormalTextComponent(
                value = stringResource(R.string.enter_your_email_address_and_we_ll_send_you_a_link_to_reset_your_password)
            )




            AuthTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 8.dp),
                label = stringResource(id = R.string.email),
                value = "",
                onValueChange = {
                },
                imageVector = Icons.Default.Email,
                isError = false,
            )




            AuthButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 8.dp),
                text = stringResource(R.string.reset_password),
                contentColor = Color.White,
            ) {
                Toast.makeText(
                    context,
                    R.string.password_reset_email_sent_please_check_your_email_for_further_instructions,
                    Toast.LENGTH_LONG
                ).show()
            }


            ClickableAuthText(
                initialText = stringResource(R.string.don_t_have_an_account),
                clickableText = stringResource(R.string.create_new)
            ) {
                onNavigationSignUpScreen()
            }


        }
    }
}


@Preview
@Composable
fun PreviewForgotPasswordScreen() {
    ForgotPasswordScreen(
        onNavigationSignUpScreen = {

        }
    )
}