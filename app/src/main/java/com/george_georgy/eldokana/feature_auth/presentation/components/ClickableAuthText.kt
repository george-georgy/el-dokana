package com.george_georgy.eldokana.feature_auth.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.george_georgy.eldokana.core.presentation.ui.theme.Black

@Composable
fun ClickableAuthText(
    initialText : String,
    clickableText : String,
    onNavigation : ()->Unit,

    ){

    val uiColor = if (isSystemInDarkTheme()) White else Black


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = initialText,
            color = Color(0xFF808080)
        )
        Text(
            modifier = Modifier
                .clickable {
                    onNavigation()
                }
                .padding(start = 4.dp),
            text = clickableText,
            color = uiColor,
            fontWeight = FontWeight.Bold
        )

    }
}