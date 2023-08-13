package com.george_georgy.eldokana.feature_home_products.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.george_georgy.eldokana.feature_home_products.domain.model.Product
import com.george_georgy.eldokana.feature_home_products.presentation.home_lists.HomeLists
import com.george_georgy.eldokana.feature_home_products.presentation.components.InstructionTopTitle
import com.george_georgy.eldokana.feature_home_products.presentation.components.Promotions

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DashboardScreen(
    onItemDetails: (Product) -> Unit
) {
    Column(
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




