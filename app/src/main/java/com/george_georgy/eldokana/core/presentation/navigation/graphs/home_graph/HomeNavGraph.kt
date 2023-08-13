package com.george_georgy.eldokana.core.presentation.navigation.graphs.home_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.george_georgy.eldokana.core.presentation.navigation.graphs.Graphs
import com.george_georgy.eldokana.core.presentation.navigation.graphs.details_graph.detailsNavGraph
import com.george_georgy.eldokana.feature_home_products.presentation.DashboardScreen
import com.george_georgy.feature_wishlist.presentaion.WishlistScreen

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graphs.HOME,
        startDestination = BottomBarRoutes.Home.route
    ) {
        composable(BottomBarRoutes.Home.route) {
            DashboardScreen(
                onItemDetails = {product ->
                    navController.currentBackStackEntry?.savedStateHandle?.set(
                        key = "product",
                        value = product
                    )
                    navController.navigate(Graphs.DETAILS)
                }

            )
        }

        composable(BottomBarRoutes.Wishlist.route) {
            WishlistScreen()

        }
        composable(BottomBarRoutes.Cart.route) {

        }

        composable(BottomBarRoutes.Profile.route) {

        }



        detailsNavGraph(navController = navController)
    }
}




