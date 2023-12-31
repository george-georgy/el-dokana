package com.george_georgy.eldokana.feature_home_products.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FireTruck
import androidx.compose.material.icons.filled.Recycling
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.george_georgy.eldokana.core.presentation.ui.theme.PrimaryDark
import com.george_georgy.eldokana.core.presentation.ui.theme.PrimaryLight
import com.george_georgy.eldokana.core.presentation.ui.theme.WhiteSmoke


@Composable
fun InstructionTopTitle() {
    Card(
        Modifier
            .height(35.dp),
        colors = CardDefaults.cardColors(
            containerColor = WhiteSmoke,
        ),
        shape = RoundedCornerShape(0.dp),


        ) {
        Row(
            Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            InstructionItem(image = Icons.Default.Recycling, "14 days free returns")

            Divider(
                color = PrimaryDark,
                modifier = Modifier
                    .padding(4.dp, top = 10.dp, bottom = 10.dp)
                    .fillMaxHeight()
                    .width(1.dp)
            )

            InstructionItem(image = Icons.Default.FireTruck, "Delivery for 30 EGP")
        }
    }
}

@Composable
fun InstructionItem(
    image: ImageVector, itemText: String
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = image,
            contentDescription = "",
            modifier = Modifier.padding(start = 4.dp, end = 4.dp)
        )
        Text(
            text = itemText,
            color = PrimaryDark,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )

    }

}

@Composable
@Preview
fun PreviewInstructionTopTitle() {
    InstructionTopTitle()

}