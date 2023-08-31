package com.george_georgy.eldokana.core.presentation.navigation.graphs.details_graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.george_georgy.eldokana.core.presentation.navigation.graphs.Graphs
import com.george_georgy.eldokana.core.presentation.navigation.graphs.home_graph.HomeRoutes
import com.george_georgy.eldokana.feature_home_products.domain.model.Product
import com.george_georgy.eldokana.feature_home_products.presentation.product_detail.ProductDetailScreen

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {
    navigation(
        route = Graphs.DETAILS,
        startDestination = DetailsScreen.Information.route
    ) {
        composable(route = DetailsScreen.Information.route) {
            val resultProduct = navController.previousBackStackEntry?.savedStateHandle?.get<Product>("product")

            if (resultProduct != null) {
                ProductDetailScreen(
                    resultProduct,

                    onBackArrowIcon = {
                        navController.popBackStack()

                    },

                    onCartButtonClick = {
                       // navController.navigate(HomeRoutes.CartScreen.route)
                    },
                )
            }
        }

    }
}