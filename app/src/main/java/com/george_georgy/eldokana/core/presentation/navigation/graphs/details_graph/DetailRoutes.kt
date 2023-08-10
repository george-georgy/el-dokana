package com.george_georgy.eldokana.core.presentation.navigation.graphs.details_graph

sealed class DetailsScreen(val route: String) {
    object Information : DetailsScreen(route = "INFORMATION")
}