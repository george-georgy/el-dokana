package com.george_georgy.eldokana.core.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.george_georgy.eldokana.core.presentation.navigation.graphs.RootNavigationGraph
import com.george_georgy.eldokana.core.presentation.ui.theme.EcommTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            EcommTheme {

                val systemUiController = rememberSystemUiController()
                LaunchedEffect(key1 = true){
                    systemUiController.setStatusBarColor(
                        color = Color.White
                    )
                }
                Surface {
                    RootNavigationGraph(navController = rememberNavController())
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EcommTheme {
        //Navigation()
    }
}