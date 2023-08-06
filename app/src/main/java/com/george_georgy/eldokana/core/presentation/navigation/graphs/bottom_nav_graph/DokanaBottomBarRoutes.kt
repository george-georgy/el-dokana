package com.george_georgy.eldokana.core.presentation.navigation.graphs.bottom_nav_graph

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class DokanaBottomBarRoutes(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : DokanaBottomBarRoutes(
        route = "HOME",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Profile : DokanaBottomBarRoutes(
        route = "PROFILE",
        title = "Profile",
        icon = Icons.Default.Person
    )

    object Cart : DokanaBottomBarRoutes(
        route = "CART",
        title = "Cart",
        icon = Icons.Default.Settings
    )

    object Wishlist : DokanaBottomBarRoutes(
        route = "WISHLIST",
        title = "Wishlist",
        icon = Icons.Default.Favorite
    )
}
