package com.george_georgy.eldokana.feature_home_products.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.george_georgy.eldokana.R
import com.george_georgy.eldokana.core.presentation.ui.theme.MyLightGray

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DokanaTopAppBar(
) {
    Row(
        Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(8.dp)),
        verticalAlignment = CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {

        Image(
            painter = painterResource(id = R.drawable.logo),
            modifier = Modifier
                .padding(end = 8.dp)
                .size(35.dp),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(8.dp))

        TextField(
            value = "",
            onValueChange = {},
            singleLine = true,

            modifier = Modifier
                .weight(1f)
                .background(
                    MyLightGray, shape = RoundedCornerShape(20.dp)
                ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                cursorColor = MyLightGray
            ),
            shape = RoundedCornerShape(size = 8.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = "search icon"
                )
            },
            placeholder = { Text(text = "What are you looking for?") },



            )


    }
}


@Composable
@Preview
fun PreviewDokanaTopAppBar() {
    DokanaTopAppBar()
}


