package com.george_georgy.eldokana.feature_home_products.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.george_georgy.eldokana.feature_home_products.domain.model.Product

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ProductListItem(
    product: Product,
    onItemClick: (Product) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                onItemClick(product)
            },
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = White,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )

    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
            .padding(8.dp),
        ) {
            GlideImage(
                model = product.image,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .padding(12.dp)
                    .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)),
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = product.title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 8.dp, 4.dp)
            )


            Text(
                text = product.category,
                color = Gray,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp),

                )

            RatingItem(product.rating.rate)

            Text(
                text = product.price.toString() + " L.E",
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp),

                )

            Spacer(modifier = Modifier.height(8.dp))


        }


    }
}
