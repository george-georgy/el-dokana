package com.george_georgy.eldokana.core.presentation.navigation.graphs.auth_graph


sealed class DokanaAuthRoutes(
    val route: String
) {
    object Splash : DokanaAuthRoutes("splash_screen")
    object Login : DokanaAuthRoutes("login_screen")
    object ForgotPassword : DokanaAuthRoutes("forgot_password_screen")
    object Register : DokanaAuthRoutes("register_screen")

}
