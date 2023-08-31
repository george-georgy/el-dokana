package com.george_georgy.eldokana.feature_profile.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.koin.androidx.compose.getViewModel

@Composable
fun ProfileScreen(
    profileViewModel: ProfileViewModel = getViewModel()
) {

    val state = profileViewModel.profileState.value

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = state.email ?: "")
    }


}