package com.george_georgy.eldokana.core.presentation.navigation.graphs.auth_graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.george_georgy.eldokana.core.presentation.navigation.graphs.bottom_nav_graph.DokanaBottomBarRoutes
import com.george_georgy.eldokana.core.presentation.navigation.graphs.Graphs
import com.george_georgy.eldokana.feature_auth.presentation.forgot_password.ForgotPasswordScreen
import com.george_georgy.eldokana.feature_auth.presentation.login.LoginScreen
import com.george_georgy.eldokana.feature_auth.presentation.signup.SignUpScreen
import com.george_georgy.eldokana.feature_auth.presentation.splash.SplashScreen


fun NavGraphBuilder.authNavGraph(navController: NavHostController) {

    navigation(
        route = Graphs.AUTHENTICATION,
        startDestination = DokanaAuthRoutes.Splash.route
    ) {
        composable(DokanaAuthRoutes.Splash.route) {
            SplashScreen(
                onUserFoundNavigation = {
                    navController.popBackStack()
                    navController.navigate(Graphs.HOME) {
                    }

                },
                onUserNotFoundNavigation = {
                    navController.popBackStack()
                    navController.navigate(DokanaAuthRoutes.Login.route) {
                    }
                }
            )
        }




        composable(DokanaAuthRoutes.Login.route) {
            LoginScreen(
                onLoginSuccess = {
                    navController.popBackStack()
                    navController.navigate(Graphs.HOME)

                },
                onNavigationSignUpScreen = {
                    navController.navigate(DokanaAuthRoutes.Register.route)


                },
                onNavigationForgetPassword = {
                    navController.navigate(DokanaAuthRoutes.ForgotPassword.route)

                }

            )
        }

        composable(DokanaAuthRoutes.ForgotPassword.route) {
            ForgotPasswordScreen(
                onNavigationSignUpScreen = {
                    navController.navigate(DokanaAuthRoutes.Register.route) {
                        popUpTo(0)
                    }
                }
            )
        }

        composable(DokanaAuthRoutes.Register.route) {
            SignUpScreen(
                onSignUpSuccess = {
                    navController.popBackStack()
                    navController.navigate(DokanaBottomBarRoutes.Home.route)

                },
                onNavigationLoginScreen = {
                    navController.navigate(DokanaAuthRoutes.Login.route)


                })
        }
    }
}

