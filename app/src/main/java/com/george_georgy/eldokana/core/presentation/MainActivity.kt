package com.george_georgy.eldokana.core.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.george_georgy.eldokana.core.presentation.navigation.graphs.RootNavigationGraph
import com.george_georgy.eldokana.core.presentation.ui.theme.EcommTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            EcommTheme {
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