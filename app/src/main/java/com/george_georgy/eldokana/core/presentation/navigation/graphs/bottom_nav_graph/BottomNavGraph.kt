package com.george_georgy.eldokana.core.presentation.navigation.graphs.bottom_nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.george_georgy.eldokana.core.presentation.navigation.graphs.Graphs
import com.george_georgy.eldokana.feature_home_products.presentation.HomeScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graphs.HOME,
        startDestination = DokanaBottomBarRoutes.Home.route
    ) {
        composable(DokanaBottomBarRoutes.Home.route) {
            HomeScreen(
                /*
                onItemDetails = {

                    navController.navigate(DetailsScreen.Information.route) {
                        popUpTo(0)
                    }



                }
            */
            )
        }

        composable(DokanaBottomBarRoutes.Wishlist.route) {

        }
        composable(DokanaBottomBarRoutes.Cart.route) {

        }

        composable(DokanaBottomBarRoutes.Profile.route) {

        }
        //detailsNavGraph(navController = navController)
        composable(route = DetailsScreen.Information.route) {



        }
    }
}

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {
    navigation(
        route = Graphs.DETAILS,
        startDestination = DetailsScreen.Information.route
    ) {
        composable(route = DetailsScreen.Information.route) {

        }

    }
}

sealed class DetailsScreen(val route: String) {
    object Information : DetailsScreen(route = "INFORMATION")
}
