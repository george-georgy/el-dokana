package com.george_georgy.eldokana.feature_auth.presentation.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.george_georgy.eldokana.core.presentation.ui.theme.Black

@Composable
fun NormalTextComponent(
    value: String
) {

    val uiColor = if (isSystemInDarkTheme()) Color.White else Black

    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth(),
        style = TextStyle(
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ), color = uiColor,
    )
}