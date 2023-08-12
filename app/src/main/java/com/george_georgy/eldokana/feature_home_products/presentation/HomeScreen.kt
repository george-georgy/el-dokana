package com.george_georgy.eldokana.feature_home_products.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.george_georgy.eldokana.feature_home_products.domain.model.Product
import com.george_georgy.eldokana.feature_home_products.presentation.category.HomeLists
import com.george_georgy.eldokana.feature_home_products.presentation.components.DokanaTopAppBar
import com.george_georgy.eldokana.feature_home_products.presentation.components.InstructionTopTitle
import com.george_georgy.eldokana.feature_home_products.presentation.components.Promotions

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onItemDetails : (Product) -> Unit
) {

    Surface {

        Scaffold(
            topBar = { DokanaTopAppBar() },
            containerColor = Color.Transparent,


            ) { paddingValues ->

            Column(
                Modifier.padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                InstructionTopTitle()

                Spacer(modifier = Modifier.height(16.dp))

                Promotions()

                Spacer(modifier = Modifier.height(16.dp))

                HomeLists(onClick = onItemDetails)

                Spacer(modifier = Modifier.height(16.dp))

            }
        }
    }
}


