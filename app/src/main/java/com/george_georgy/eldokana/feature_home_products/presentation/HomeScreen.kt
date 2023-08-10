package com.george_georgy.eldokana.feature_home_products.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.george_georgy.eldokana.core.presentation.navigation.graphs.bottom_nav_graph.DokanaBottomBar
import com.george_georgy.eldokana.feature_home_products.presentation.components.DokanaTopAppBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController : NavHostController) {

    Surface {

        Scaffold(
            topBar = { DokanaTopAppBar() },
            containerColor = Color.Transparent,

            bottomBar = { DokanaBottomBar(navController = navController) }



        ) { paddingValues ->

            HomeContent(paddingValues)

        }
    }
}


