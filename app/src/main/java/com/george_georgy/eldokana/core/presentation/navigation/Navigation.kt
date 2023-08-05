package com.george_georgy.eldokana.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.george_georgy.shopnow.feature_home_products.presentation.HomeScreen
import com.george_georgy.eldokana.feature_auth.presentation.forgot_password.ForgotPasswordScreen
import com.george_georgy.eldokana.feature_auth.presentation.login.LoginScreen
import com.george_georgy.eldokana.feature_auth.presentation.signup.SignUpScreen
import com.george_georgy.eldokana.feature_auth.presentation.splash.SplashScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.SplashScreen.route
    ) {

        composable(ScreenRoutes.SplashScreen.route) {
            SplashScreen(
                onUserFoundNavigation = {
                    navController.navigate(ScreenRoutes.HomeScreen.route) {
                        popUpTo(0)
                    }

                },
                onUserNotFoundNavigation = {
                    navController.navigate(ScreenRoutes.LoginScreen.route) {
                        popUpTo(0)
                    }
                }
            )
        }




        composable(ScreenRoutes.LoginScreen.route) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(ScreenRoutes.HomeScreen.route) {
                        popUpTo(0)
                    }
                },
                onNavigationSignUpScreen = {
                    navController.navigate(ScreenRoutes.RegisterScreen.route) {
                        popUpTo(0)
                    }

                },
                onNavigationForgetPassword = {
                    navController.navigate(ScreenRoutes.ForgotPassword.route) {
                    }
                }

            )
        }

        composable(ScreenRoutes.ForgotPassword.route) {
            ForgotPasswordScreen(
                onNavigationSignUpScreen = {
                    navController.navigate(ScreenRoutes.RegisterScreen.route) {
                        popUpTo(0)
                    }
                }
            )
        }

        composable(ScreenRoutes.RegisterScreen.route) {
            SignUpScreen(
                onSignUpSuccess = {
                    navController.navigate(ScreenRoutes.HomeScreen.route) {
                        popUpTo(0)
                    }
                },
                onNavigationLoginScreen = {
                    navController.navigate(ScreenRoutes.LoginScreen.route) {
                        popUpTo(0)
                    }

                })
        }

        composable(ScreenRoutes.HomeScreen.route) {
            HomeScreen(
                onNavigation = {
                    navController.navigate(ScreenRoutes.LoginScreen.route) {
                        popUpTo(0)
                    }
                }
            )
        }

        composable(ScreenRoutes.WishListScreen.route) {

        }
        composable(ScreenRoutes.CartScreen.route) {

        }

        composable(ScreenRoutes.ProfileScreen.route) {

        }



    }
}



