package com.george_georgy.eldokana.feature_home_products.presentation.home_lists

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.george_georgy.eldokana.core.presentation.ui.theme.PrimaryDark
import com.george_georgy.eldokana.core.presentation.ui.theme.PrimaryLight
import com.george_georgy.eldokana.feature_home_products.domain.model.Product
import com.george_georgy.eldokana.feature_home_products.presentation.components.ProductListItem
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeLists(
    homeViewModel: HomeViewModel = getViewModel(),
    onClick : (Product) -> Unit

) {


    val categories = homeViewModel.categoriesState.value
    val selectedCategory = homeViewModel.selectedCategory.value
    val products = homeViewModel.productState.value.products

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(),

        ) {

        LazyRow(
            Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)

        ) {
            items(categories) { category ->
                Text(
                    text = category,
                    color = if (category == selectedCategory) Color.White else PrimaryDark,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .clip(
                            shape = RoundedCornerShape(
                                size = 8.dp,
                            ),
                        )
                        .clickable {
                            homeViewModel.onHomeEvent(HomeEvent.CategoryChanged(category))
                        }
                        .background(
                            if (category == selectedCategory) {
                                PrimaryDark

                            } else {
                                PrimaryLight
                            }
                        )
                        .padding(
                            10.dp
                        )
                )
            }
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(2), // Number of columns in the grid
            contentPadding = PaddingValues(16.dp)
        ) {
            items(products) { product ->
                ProductListItem(product, onClick)
            }
        }
    }


}

