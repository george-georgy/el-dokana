package com.george_georgy.eldokana.feature_auth.presentation.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.george_georgy.eldokana.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthPasswordTextField(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    errorValue : String?,
    onValueChange: (String) -> Unit,
    imageVector: ImageVector,
    isError: Boolean,


    ) {
    val uiColor = if (isSystemInDarkTheme()) Color.White else Color.Black


     val passwordVisible = remember{
       mutableStateOf(false)
     }



    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium,
                color = uiColor
            )
        },
        leadingIcon = {
            Icon(
                imageVector = imageVector,
                contentDescription = ""
            )
        },

        supportingText = {
            Text(
                text = errorValue ?: "",
                color = Color.Red
            )
        },
        isError = isError,

        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),

        trailingIcon = {

            val showPasswordIcon = if(passwordVisible.value){
                Icons.Filled.Visibility
            }else{
                Icons.Filled.VisibilityOff
            }

            var description = if(passwordVisible.value){
                stringResource(R.string.hide_password)
            }else{
                stringResource(R.string.show_password)
            }

            IconButton(onClick = { passwordVisible.value = !passwordVisible.value}) {
                Icon(imageVector = showPasswordIcon, contentDescription = description)
                
            }
        },
        visualTransformation = if(passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation()



        )


}