package com.george_georgy.eldokana.feature_home_products.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.george_georgy.eldokana.feature_home_products.domain.model.Product
import com.george_georgy.eldokana.feature_home_products.domain.model.Rating

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun ProductItem(
    product: Product,
    onClick: (Product) -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.wrapContentHeight().widthIn(100.dp)
            .padding(4.dp)
            .clickable {
                onClick(product)
            },
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        border = BorderStroke(width = 1.dp, color = Color.Black)
    ) {
        Column(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            GlideImage(
                model = product.image,
                contentDescription = null,
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .align(Alignment.CenterHorizontally
                    ),
                contentScale = ContentScale.Inside
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = product.title,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier,
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.Top,
            ) {
                Icon(
                    modifier = Modifier
                        .size(18.dp)
                        .align(Alignment.CenterVertically),
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    tint = Color.Yellow
                )
                Text(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    text = "${product.rating.rate} (${product.rating.count})",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "$${product.price}",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )


            Spacer(modifier = Modifier.height(12.dp))
        }

    }
}
@Composable
@Preview
fun PreviewProductItem() {
    ProductItem(
        Product(
            id = 1,
            category = "men's clothing",
            description = "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
            image = "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
            price = 109.95,
            rating = Rating(
                rate =3.9,
                count = 120
            ),
            title = "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops"


        ),
        onClick = {}
    )

}