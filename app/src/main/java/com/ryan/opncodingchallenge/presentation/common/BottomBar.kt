package com.ryan.opncodingchallenge.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ryan.opncodingchallenge.presentation.view.store.components.CheckoutButton

@Composable
fun BottomBar(
    modifier: Modifier,
    navigateCheckOut: () -> Unit
) {
    Box(
        modifier = modifier
    ) {
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Total: 0 THB",
                    modifier = Modifier.padding(start = 20.dp),
                )
                CheckoutButton(
                    onClick = {
                        navigateCheckOut()
                    },
                    modifier = Modifier.padding(end = 20.dp)
                )
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun BottomBarPreview() {
    BottomBar(
        modifier = Modifier,
        navigateCheckOut = {}
    )
}