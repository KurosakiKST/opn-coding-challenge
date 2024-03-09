package com.ryan.opncodingchallenge.presentation.view.store.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.ryan.opncodingchallenge.presentation.view.ui.theme.Grey400
import com.ryan.opncodingchallenge.presentation.view.ui.theme.Teal900

@Composable
fun CheckoutButton(
    modifier: Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Teal900,
            contentColor = Color.White,
            disabledContainerColor = Grey400,
            disabledContentColor = Color.White
        )
    ) {
        Text(text = "Checkout")
    }
}