package com.ryan.opncodingchallenge.presentation.view.store.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ryan.opncodingchallenge.R
import com.ryan.opncodingchallenge.presentation.model.ProductUIModel

@Composable
fun QuantitySelector(
    item: ProductUIModel,
    quantity: Int,
    onQuantityChange: (Int) -> Unit,
    onIncreaseClick: () -> Unit,
    onDecreaseClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "${item.price} THB",
            fontFamily = FontFamily(Font(R.font.urbanist_medium)),
            fontSize = 14.sp,
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(50.dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(19.dp)
                )
        ) {
            IconButton(
                onClick = onDecreaseClick,
                modifier = Modifier.size(24.dp)
            ) {
                val decreaseIcon =
                    if (quantity > 0) R.drawable.ic_minus_enabled else R.drawable.ic_minus_disabled

                Image(
                    painter = painterResource(id = decreaseIcon),
                    contentDescription = "Decrease"
                )
            }

            Text(
                text = quantity.toString(),
                fontFamily = FontFamily(Font(R.font.urbanist_medium)),
                fontSize = 14.sp,
                modifier = Modifier.padding(horizontal = 8.dp)
            )

            IconButton(
                onClick = onIncreaseClick,
                modifier = Modifier.size(24.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = "Increase"
                )
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun QuantitySelectorPreview() {
    QuantitySelector(
        item = ProductUIModel(
            productName = "Coffee",
            price = 1000,
            imageUrl = "https://www.nespresso.com/ncp/res/uploads/recipes/nespresso-recipes-Latte-Art-Tulip.jpg"
        ),
        quantity = 1,
        onQuantityChange = {},
        onDecreaseClick = {},
        onIncreaseClick = {}
    )
}