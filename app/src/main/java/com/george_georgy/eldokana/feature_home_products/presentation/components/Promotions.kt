package com.george_georgy.eldokana.feature_home_products.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.george_georgy.eldokana.R
import com.george_georgy.eldokana.core.presentation.ui.theme.PrimaryDark
import java.nio.file.WatchEvent


@Composable
fun Promotions() {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            PromotionItem(
                imagePainter = painterResource(id = R.drawable.discount),
                title = stringResource(R.string.a_summer_surprise),
                subtitle = stringResource(R.string.up_to_50_off_on_selected_items),
                backgroundColor = Color(0xFFe7e7e7)
            )
        }
        item {
            PromotionItem(
                imagePainter = painterResource(id = R.drawable.sale),
                title = stringResource(R.string.a_summer_surprise),
                subtitle = stringResource(R.string.don_t_miss_out_on_these_amazing_deals),
                backgroundColor = Color(0xFFe7e7e7)
            )
        }
    }
}

@Composable
fun PromotionItem(
    title: String = "",
    subtitle: String = "",
    backgroundColor: Color = Color.Transparent,
    imagePainter: Painter
) {
    Card(
        Modifier
            .width(330.dp)
            .wrapContentHeight(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor,
        ),
    ) {
        Row(
            modifier = Modifier.padding(start = 12.dp , top=12.dp, bottom = 12.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,

            ) {
            Column(
                Modifier
                    .weight(.75f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = title,
                    fontSize = 15.sp,
                    color = PrimaryDark
                )
                Text(
                    text = subtitle,
                    fontSize = 15.sp,
                    color = PrimaryDark,
                    fontWeight = FontWeight.Bold
                )
            }

            Image(
                painter = imagePainter,
                contentDescription = "",
                modifier = Modifier
                    .weight(.25f)
                    .size(35.dp)
            )

        }
    }
}

@Composable
@Preview
fun PreviewPromotions() {
    Promotions()
}



