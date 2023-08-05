package com.george_georgy.eldokana.core.presentation.navigation

sealed class ScreenRoutes(
    val route: String
) {
    object SplashScreen : ScreenRoutes("splash_screen")
    object LoginScreen : ScreenRoutes("login_screen")
    object ForgotPassword : ScreenRoutes("forgot_password_screen")
    object RegisterScreen : ScreenRoutes("register_screen")

    object HomeScreen : ScreenRoutes("home_screen")
    object CartScreen : ScreenRoutes("cart_screen")
    object ProfileScreen : ScreenRoutes("profile_screen")
    object WishListScreen : ScreenRoutes("wishList_screen")


}
