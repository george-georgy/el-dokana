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

val PrimaryLight = Color(0xFFF5F5F5)
val PrimaryDark = Color(0xFF333333)






val ColorScheme.focusedTextFieldText
    @Composable
    get() = if (isSystemInDarkTheme()) White else Black

val ColorScheme.PrimaryColor get() = Color(0xFF659125);
val ColorScheme.PrimaryLightColor get() = Color(0xFFE2F7D2);