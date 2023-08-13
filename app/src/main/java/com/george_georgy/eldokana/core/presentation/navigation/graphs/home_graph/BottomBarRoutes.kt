package com.george_georgy.eldokana.core.presentation.navigation.graphs.home_graph

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarRoutes(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomBarRoutes(
        route = HomeRoutes.HomeScreen.route,
        title = "Home",
        icon = Icons.Default.Home
    )

    object Profile : BottomBarRoutes(
        route = HomeRoutes.ProfileScreen.route,
        title = "Profile",
        icon = Icons.Default.Person
    )

    object Cart : BottomBarRoutes(
        route = HomeRoutes.CartScreen.route,
        title = "Cart",
        icon = Icons.Default.ShoppingCart
    )

    object Wishlist : BottomBarRoutes(
        route = HomeRoutes.WishlistScreen.route,
        title = "Wishlist",
        icon = Icons.Default.Favorite
    )
}