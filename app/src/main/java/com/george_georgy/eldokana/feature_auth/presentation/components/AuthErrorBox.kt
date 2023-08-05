package com.george_georgy.eldokana.feature_auth.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ErrorAuthBox(
    error : String? = null,

){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(27.dp)

    ) {
        if (error != null) {

            Text(
                text = error,

                color = MaterialTheme.colorScheme.error,
                fontSize = 12.sp

            )
        }
    }

}