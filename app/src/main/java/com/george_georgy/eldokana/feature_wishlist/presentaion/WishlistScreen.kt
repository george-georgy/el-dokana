package com.george_georgy.eldokana.feature_wishlist.presentaion

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.george_georgy.eldokana.core.presentation.ui.theme.PrimaryLight
import com.george_georgy.eldokana.feature_wishlist.data.mapper.toWish
import com.george_georgy.eldokana.feature_wishlist.domain.model.Wish
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WishlistScreen(
    viewModel: WishlistViewModel = getViewModel(),
    onClickWishItem : (Wish)->Unit
) {
    val wishlist = viewModel.wishItemState.value
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 24.dp),
                        text = "Wishlist",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                },
                actions = {
                    IconButton(
                        onClick = {
                            viewModel.deleteAllWishlist()
                        },
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Delete,
                            contentDescription = null,
                            tint = Color.Black
                        )
                    }
                }
            )
        }
    ) {paddingValues->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = PrimaryLight)
                .padding(paddingValues),

        ) {

            Column {

                LazyColumn {
                    items(items = wishlist) {wishlistEntity->
                        WishlistItem(
                            wish = wishlistEntity.toWish(),
                            onClickDeleteIcon = {
                                viewModel.deleteFromWishlist(it)
                            },
                            onClickWishItem = {
                                onClickWishItem(it)

                            }

                        )
                    }
                }

            }

        }
    }
}