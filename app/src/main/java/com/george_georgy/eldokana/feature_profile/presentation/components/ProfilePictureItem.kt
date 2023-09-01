package com.george_georgy.eldokana.feature_profile.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfilePictureItem(
    userPicture: Painter,
    name: String?,
    email: String?
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Start
    ) {

        // Profile Icon
        Image(
            painter = userPicture,
            contentDescription = null,
            modifier = Modifier
                .padding(end = 16.dp)
                .size(76.dp)
                .clip(shape = CircleShape)
                .background(MaterialTheme.colorScheme.primary)
        )

        Column(
            verticalArrangement = Arrangement.Top

        ) {
            Text(
                text = name ?: "",
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = email ?: "",
                fontSize = 14.sp,
                color = Color.Gray,
            )


        }

    }

}



