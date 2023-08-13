package com.george_georgy.eldokana.feature_home_products.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

import com.george_georgy.eldokana.core.presentation.navigation.graphs.home_graph.DokanaBottomBar
import com.george_georgy.eldokana.core.presentation.navigation.graphs.home_graph.HomeNavGraph
import com.george_georgy.eldokana.core.presentation.navigation.graphs.home_graph.HomeRoutes
import com.george_georgy.eldokana.feature_home_products.presentation.components.DokanaTopAppBar


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("RememberReturnType")
@Composable
fun HomeScreen(
    navController: NavHostController = rememberNavController(),
) {

    //topBar visibility state
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination


    Scaffold(
        topBar = {
            if (currentDestination?.route == HomeRoutes.HomeScreen.route) {
                DokanaTopAppBar()
            }
        },
        bottomBar = {
            DokanaBottomBar(navController = navController)
        }

    ) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
        ) {

            HomeNavGraph(navController = navController)
        }
    }
}