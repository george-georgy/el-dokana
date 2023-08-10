package com.george_georgy.eldokana.core.presentation.navigation.graphs.auth_graph


sealed class AuthRoutes(
    val route: String
) {
    object Splash : AuthRoutes("splash_screen")
    object Login : AuthRoutes("login_screen")
    object ForgotPassword : AuthRoutes("forgot_password_screen")
    object Register : AuthRoutes("register_screen")

}
