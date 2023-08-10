package com.george_georgy.eldokana.core.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White


val Black = Color(0xFF000113)
val LightBlueWhite = Color(0xFFF1F5F9)
val BlueGray = Color(0xFF334155)

val DarkBlue = Color(0xFF00427A)
val LightBlue = Color(0xFF75B7EE)
val MyLightGray = Color(0xFFECECEC)

val green = Color(0xFF01cd98)
val greenLight = Color(0xFF00FFBD)


val ColorScheme.focusedTextFieldText
    @Composable
    get() = if (isSystemInDarkTheme()) White else Black

val ColorScheme.unfocusedTextFieldText
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFF94A3B8) else Color(0xFF475569)

val ColorScheme.textFieldContainer
    @Composable
    get() = if (isSystemInDarkTheme()) BlueGray.copy(alpha = 0.6f) else LightBlueWhite