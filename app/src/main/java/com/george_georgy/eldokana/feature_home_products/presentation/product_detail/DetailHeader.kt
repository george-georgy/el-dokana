package com.george_georgy.eldokana.feature_home_products.presentation.product_detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.george_georgy.eldokana.core.presentation.ui.theme.PrimaryDark

@Composable
fun DetailHeader(
    onBackButtonClick: () -> Unit,
    onCartButtonClick: () -> Unit
) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            Modifier
                .size(25.dp)
                .clickable {
                    onBackButtonClick()
                },
            tint = PrimaryDark
        )

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            imageVector = Icons.Default.FavoriteBorder,
            contentDescription = "Favorite",
            Modifier
                .size(25.dp)
                .clickable {
                    onCartButtonClick()
                },
            tint = PrimaryDark
        )
    }
}

@Preview
@Composable
fun DetailHeaderPreview() {
    DetailHeader(
        onBackButtonClick = {},
        onCartButtonClick = {}
    )
}