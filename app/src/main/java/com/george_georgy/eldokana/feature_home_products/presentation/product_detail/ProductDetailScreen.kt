package com.george_georgy.eldokana.feature_home_products.presentation.product_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.george_georgy.eldokana.core.presentation.ui.theme.PrimaryDark
import com.george_georgy.eldokana.feature_home_products.domain.model.Product

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ProductDetailScreen(
    product: Product?,
    onBackButtonClick: () -> Unit,
    onCartButtonClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(
                start = 30.dp, top = 48.dp, end = 30.dp
            )
    )
    {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                .fillMaxSize()
                .verticalScroll(
                    rememberScrollState()
                )
        ) {

            DetailHeader(
                onBackButtonClick = { onBackButtonClick() },
                onCartButtonClick = { onCartButtonClick() }
            )

            Spacer(modifier = Modifier.height(32.dp))

            GlideImage(
                model = product?.image,
                contentDescription = "",
                modifier = Modifier.size(275.dp)
            )



            Spacer(modifier = Modifier.height(20.dp))



            Text(
                text = product?.title ?: "",
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.Black,
                maxLines = 2,
            )

            Spacer(modifier = Modifier.height(5.dp))



            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
            )
            {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {


                    Text(
                        text = "${product?.price}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color.Black
                    )
                    Text(
                        text = "L.E",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color.Black
                    )
                }
            }






            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = product?.description ?: "",
                // style = Typography.h5,
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.weight(1f))
/*
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = ) {

            }
*/
            FloatingActionButton(
                onClick = onCartButtonClick,
                containerColor = PrimaryDark,
                contentColor = Color.White,
                elevation = FloatingActionButtonDefaults.elevation(8.dp),

                ) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "Add",
                    modifier = Modifier.padding(16.dp),
                    tint = Color.White

                )
            }

            Spacer(modifier = Modifier.height(20.dp))


        }
    }

}

