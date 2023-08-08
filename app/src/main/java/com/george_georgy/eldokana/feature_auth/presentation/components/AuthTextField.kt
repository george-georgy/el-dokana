package com.george_georgy.eldokana.feature_auth.presentation.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import com.george_georgy.eldokana.core.presentation.ui.theme.focusedTextFieldText
import com.george_georgy.eldokana.core.presentation.ui.theme.textFieldContainer
import com.george_georgy.eldokana.core.presentation.ui.theme.unfocusedTextFieldText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthTextField(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    errorValue: String?,
    onValueChange: (String) -> Unit,
    imageVector: ImageVector,
    isError: Boolean,

) {
    val textUiColor = if (isSystemInDarkTheme()) Color.White else Color.Black

    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium,
                color = textUiColor
            )
        },
        supportingText = {
            Text(
                text = errorValue ?: "",
                color = Color.Red
            )
        },
        leadingIcon = {
            Icon(
                imageVector = imageVector,
                contentDescription = ""
            )
        },
        isError = isError,

        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text
        ),

    )


}