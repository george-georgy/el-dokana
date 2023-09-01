package com.george_georgy.eldokana.feature_home_products.presentation.product_detail

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.george_georgy.eldokana.core.presentation.ui.theme.PrimaryDark
import com.george_georgy.eldokana.core.presentation.ui.theme.PrimaryLight
import com.george_georgy.eldokana.core.presentation.ui.theme.WhiteSmoke
import com.george_georgy.eldokana.feature_home_products.domain.model.Product
import com.george_georgy.eldokana.feature_home_products.presentation.components.RatingItem
import com.george_georgy.eldokana.feature_wishlist.domain.model.Wish
import com.george_georgy.eldokana.feature_wishlist.presentaion.WishlistViewModel
import org.koin.androidx.compose.getViewModel
import timber.log.Timber

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalGlideComposeApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(
    product: Product,
    onBackArrowIcon: () -> Unit,
    onCartButtonClick: () -> Unit,
    viewModel: WishlistViewModel = getViewModel()
) {


    // if isInWishlist() is null so inWishlist false
    // if isInWishlist() is not null so inWishlist true
    val inWishlist = viewModel.isInWishlist(product.id).observeAsState().value != null


    Box(
        modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),
    ) {

        Scaffold(
            topBar = {
                TopAppBar(
                    navigationIcon = {
                        IconButton(
                            modifier = Modifier
                                .background(
                                    color = Color(0xFFe7e7e7), shape = RoundedCornerShape(15.dp)
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
                    },
                    title = {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(18.dp),
                            text = "",
                            fontWeight = FontWeight.SemiBold,
                        )
                    },
                    actions = {
                        IconButton(
                            modifier = Modifier
                                .background(
                                    color = Color(0xFFe7e7e7), shape = RoundedCornerShape(15.dp)
                                ),
                            onClick = {
                                if (inWishlist) {
                                    viewModel.deleteFromWishlist(
                                        Wish(
                                            image = product.image,
                                            title = product.title,
                                            id = product.id,
                                            liked = true,
                                            price = product.price,
                                            description = product.description,
                                            category = product.category,
                                            rating = product.rating
                                        )
                                    )
                                } else {
                                    viewModel.insertFavorite(
                                        Wish(
                                            image = product.image,
                                            title = product.title,
                                            id = product.id,
                                            liked = true,
                                            price = product.price,
                                            description = product.description,
                                            category = product.category,
                                            rating = product.rating
                                        )
                                    )
                                }

                            },
                        ) {
                            Icon(
                                imageVector = Icons.Default.Favorite,
                                tint = if (inWishlist) {
                                    PrimaryDark
                                } else {
                                    Color.Gray
                                },

                                contentDescription = null,
                                modifier = Modifier.size(28.dp)
                            )
                        }
                    }
                )
            },

            floatingActionButton = {
                FloatingActionButton(
                    onClick = onCartButtonClick,
                    containerColor = PrimaryDark,
                    contentColor = Color.White,
                    elevation = FloatingActionButtonDefaults.elevation(8.dp),

                    ) {
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "Add",
                        tint = Color.White

                    )
                }
            },


        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()

            ) {

                Spacer(modifier = Modifier.height(60.dp))

                GlideImage(
                    model = product.image,
                    contentDescription = "",
                    modifier = Modifier
                        .size(300.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                Card(
                    modifier = Modifier
                        .fillMaxSize(),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFe7e7e7),
                    ),
                    shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 8.dp
                    )
                ) {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                            .verticalScroll(
                                rememberScrollState()
                            )
                    ) {

                        Spacer(modifier = Modifier.height(20.dp))

                        Text(
                            text = product.title,
                            modifier = Modifier.fillMaxWidth(),
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Color.Black,
                            maxLines = 2,
                        )

                        Spacer(modifier = Modifier.height(16.dp))



                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(40.dp),
                        )
                        {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                            ) {


                                Text(
                                    text = "${product.price} L.E",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 18.sp,
                                    textAlign = TextAlign.Start
                                )

                                RatingItem(productRatingCount = product.rating.rate)

                            }
                        }
                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = product.description,
                            fontSize = 14.sp,
                            color = Color.Black,
                            modifier = Modifier.fillMaxWidth()
                        )

                    }

                    Spacer(modifier = Modifier.weight(1f))





                }
            }
        }
    }
}





