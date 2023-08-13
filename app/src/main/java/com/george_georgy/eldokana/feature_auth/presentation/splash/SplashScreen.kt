package com.george_georgy.eldokana.feature_auth.presentation.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.george_georgy.eldokana.R
import com.george_georgy.eldokana.core.presentation.ui.theme.PrimaryDark
import com.george_georgy.eldokana.feature_auth.util.Constants.SPLASH_SCREEN_DURATION
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import org.koin.androidx.compose.getViewModel

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = getViewModel(),
    onUserFoundNavigation: () -> Unit,
    onUserNotFoundNavigation: () -> Unit,
) {


        Column(
            Modifier.fillMaxSize()
                .background(PrimaryDark),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val scale = remember {
                Animatable(0f)
            }

            val overshootInterpolator = remember {
                OvershootInterpolator(1.5f)
            }

            LaunchedEffect(key1 = true) {
                withContext(Dispatchers.Main) {
                    scale.animateTo(
                        targetValue = 1.0f,
                        animationSpec = tween(
                            durationMillis = 500,
                            easing = {
                                overshootInterpolator.getInterpolation(it)
                            }
                        )
                    )

                    delay(SPLASH_SCREEN_DURATION)

                    val eventState = viewModel.eventState.value

                    if (eventState) {
                        onUserFoundNavigation()
                    } else {
                        onUserNotFoundNavigation()
                    }
                }
            }

            Icon(
                modifier = Modifier.padding(24.dp)
                    .size(55.dp),
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                tint = Color.White
            )

        }
    }

