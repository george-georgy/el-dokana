package com.george_georgy.eldokana.core.presentation.navigation.graphs.details_graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.george_georgy.eldokana.core.presentation.navigation.graphs.Graphs

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {
    navigation(
        route = Graphs.DETAILS,
        startDestination = DetailsScreen.Information.route
    ) {
        composable(route = DetailsScreen.Information.route) {

        }

    }
}