package com.george_georgy.eldokana.core.presentation.navigation.graphs.home_graph

sealed class HomeRoutes(val route: String) {

    object HomeScreen : HomeRoutes("home_screen")
    object CartScreen : HomeRoutes("cart_screen")
    object ProfileScreen : HomeRoutes("profile_screen")
    object WishlistScreen : HomeRoutes("wishlist_screen")
}
