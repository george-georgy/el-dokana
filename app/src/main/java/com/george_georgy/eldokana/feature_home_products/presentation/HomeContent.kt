package com.george_georgy.eldokana.feature_home_products.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.george_georgy.eldokana.feature_home_products.presentation.components.CategoriesList
import com.george_georgy.eldokana.feature_home_products.presentation.components.InstructionTopTitle
import com.george_georgy.eldokana.feature_home_products.presentation.components.Promotions

@Composable
fun HomeContent(paddingValues: PaddingValues) {
    Column(
        Modifier.padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        InstructionTopTitle()

        Spacer(modifier = Modifier.height(16.dp))

        Promotions()

        Spacer(modifier = Modifier.height(16.dp))

        CategoriesList(
            onSelectCategory = {},
            selectedCategory = "All"
        )


        Spacer(modifier = Modifier.height(16.dp))

    }

}
