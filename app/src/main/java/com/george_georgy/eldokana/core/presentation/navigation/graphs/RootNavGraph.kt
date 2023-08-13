package com.george_georgy.eldokana.core.presentation.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.george_georgy.eldokana.core.presentation.navigation.graphs.auth_graph.authNavGraph
import com.george_georgy.eldokana.feature_home_products.presentation.HomeScreen

@Composable
fun RootNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graphs.ROOT,
        startDestination = Graphs.AUTHENTICATION
    ) {
        authNavGraph(navController = navController)
        composable(route = Graphs.HOME) {
            HomeScreen()
        }
    }
}

