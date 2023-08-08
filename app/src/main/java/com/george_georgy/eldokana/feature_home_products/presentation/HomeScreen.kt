package com.george_georgy.eldokana.feature_home_products.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.george_georgy.eldokana.feature_home_products.presentation.components.DokanaTopAppBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    Surface {

        Box {
            /*
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(0.dp, (-30).dp),
                painter = painterResource(id = R.drawable.bk_main),
                contentDescription = "Home background",
                contentScale = ContentScale.FillWidth
            )

             */

            Scaffold(
                topBar = { DokanaTopAppBar() },
                containerColor = Color.Transparent
            ) {
                    paddingValues ->
                HomeContent(paddingValues)

            }
        }
    }
}

@Composable
@Preview
fun PreviewHomeScreen() {
    HomeScreen()
}
