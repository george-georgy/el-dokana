package com.george_georgy.eldokana.feature_auth.presentation.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.george_georgy.eldokana.core.presentation.ui.theme.BlueGray

@Composable
fun AuthButton(
    modifier: Modifier = Modifier,
    text: String,
    contentColor: Color,
    isEnabled: Boolean = true,
    onButtonClicked: () -> Unit,

    ) {

    val uiColor = if (isSystemInDarkTheme()) BlueGray else Color.Black


    Button(
        modifier = modifier, onClick = {
            onButtonClicked()
        }, shape = RoundedCornerShape(6.dp), colors = ButtonDefaults.buttonColors(
            containerColor = uiColor,
            contentColor = contentColor,
            disabledContainerColor = uiColor,
            disabledContentColor = contentColor
        ), enabled = isEnabled

    ) {


        Text(
            text = text,
            fontSize = 18.sp,
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.Bold
        )

    }


}

@Preview(showSystemUi = true)
@Composable
fun AuthButtonPreview() {
    AuthButton(
        modifier = Modifier.fillMaxWidth(),
        text = "Sign Up",
        contentColor = Color.Black,
    ) {

    }
}
