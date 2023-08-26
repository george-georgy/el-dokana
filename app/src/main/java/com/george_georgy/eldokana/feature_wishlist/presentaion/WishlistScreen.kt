package com.george_georgy.eldokana.feature_wishlist.presentaion

import android.annotation.SuppressLint
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.george_georgy.eldokana.R
import com.george_georgy.eldokana.core.presentation.ui.theme.PrimaryDark
import com.george_georgy.eldokana.core.presentation.ui.theme.PrimaryLight
import com.george_georgy.eldokana.core.utils.UiEvent
import com.george_georgy.eldokana.feature_wishlist.data.mapper.toWish
import com.george_georgy.eldokana.feature_wishlist.domain.model.Wish
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.getViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun WishlistScreen(
    viewModel: WishlistViewModel = getViewModel(),
    onClickWishItem: (Wish) -> Unit,
    onBackArrowIcon: () -> Unit,

    ) {


    val wishlist = viewModel.wishItemState.value
    val snackbarHostState = remember { SnackbarHostState() }


    LaunchedEffect(key1 = true) {
        viewModel.wishlistEventResult.collectLatest { event ->
            when (event) {
                is UiEvent.SnackbarEvent -> {
                    snackbarHostState.showSnackbar(event.result)
                }
            }
        }
    }


    Scaffold(

        snackbarHost = { SnackbarHost(snackbarHostState) }, topBar = {
            TopAppBar(
                modifier = Modifier.padding(top = 12.dp, start = 16.dp, end = 16.dp),
                navigationIcon = {
                    IconButton(
                        modifier = Modifier
                            .background(
                                color = Color(0xFFe7e7e7),
                                shape = RoundedCornerShape(15.dp)
                            ),
                        onClick = {
                            onBackArrowIcon()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "",
                        )
                    }
                }, title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "My Wishlist",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,

                        )
                }, actions = {
                    IconButton(
                        modifier = Modifier
                            .background(
                                color = Color(0xFFe7e7e7), shape = RoundedCornerShape(15.dp)
                            ),
                        onClick = {
                            viewModel.deleteAllWishlist()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "",
                        )
                    }
                })
        }) { paddingValues ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),

            ) {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = PrimaryLight)

            ) {
                items(
                    items = wishlist,
                    key = { it.id }
                ) { wishlistEntity ->
                    WishlistItem(
                        wish = wishlistEntity.toWish(),
                        onClickDeleteIcon = {
                            viewModel.deleteFromWishlist(it)
                        },
                        onClickWishItem = {
                            onClickWishItem(it)

                        },
                        modifier = Modifier.animateItemPlacement(
                            animationSpec = tween(
                                durationMillis = 500
                            )
                        ),


                        )
                }
            }

        }

        if ((wishlist.isEmpty())) {
            Column(
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier.size(220.dp),
                    painter = painterResource(id = R.drawable.empty_shopping_bag),
                    contentDescription = null
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Your wishlist is lonely. Add items to start shopping",
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold

                    )
            }
        }
    }
}

