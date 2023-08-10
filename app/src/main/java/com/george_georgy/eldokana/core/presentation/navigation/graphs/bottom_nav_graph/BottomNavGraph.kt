package com.george_georgy.eldokana.core.presentation.navigation.graphs.bottom_nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.george_georgy.eldokana.core.presentation.navigation.graphs.Graphs
import com.george_georgy.eldokana.core.presentation.navigation.graphs.details_graph.DetailsScreen
import com.george_georgy.eldokana.feature_home_products.presentation.HomeScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graphs.HOME,
        startDestination = BottomBarRoutes.Home.route
    ) {
        composable(BottomBarRoutes.Home.route) {
            HomeScreen(navController
                /*
                onItemDetails = {

                    navController.navigate(DetailsScreen.Information.route) {
                        popUpTo(0)
                    }



                }
            */
            )
        }

        composable(BottomBarRoutes.Wishlist.route) {

        }
        composable(BottomBarRoutes.Cart.route) {

        }

        composable(BottomBarRoutes.Profile.route) {

        }
        //detailsNavGraph(navController = navController)
        composable(route = DetailsScreen.Information.route) {



        }
    }
}




