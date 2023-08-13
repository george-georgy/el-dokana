package com.george_georgy.feature_wishlist.presentaion

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.george_georgy.eldokana.core.presentation.navigation.graphs.home_graph.HomeRoutes

@Composable
fun WishlistScreen(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = "WishList",
        )

    }
}