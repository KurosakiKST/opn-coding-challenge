package com.ryan.opncodingchallenge.presentation.view.store.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.ryan.opncodingchallenge.R
import com.ryan.opncodingchallenge.presentation.model.ProductUIModel
import com.ryan.opncodingchallenge.presentation.view.ui.theme.Teal900

@Composable
fun ProductItem(
    item: ProductUIModel,
    onSelectionChange: (ProductUIModel, Boolean) -> Unit,
    onQuantityChange: (ProductUIModel, Int) -> Unit
) {
    var quantity by remember { mutableStateOf(0) }
    var isChecked by remember {
        mutableStateOf(false)
    }

    ElevatedCard(
        modifier = Modifier
            .padding(5.dp)
            .width(160.dp)
            .height(220.dp),
        shape = RoundedCornerShape(5.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
            ) {
                AsyncImage(
                    model = item.imageUrl,
                    contentDescription = null,
                    placeholder = painterResource(id = R.drawable.placehold_512),
                    error = painterResource(id = R.drawable.placehold_512),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                Checkbox(
                    checked = isChecked,
                    onCheckedChange = { isCheckedValue ->
                        isChecked = isCheckedValue
                        onSelectionChange(item, isChecked)
                        if (isCheckedValue) {
                            quantity = 1
                            onQuantityChange(item, quantity)
                        } else {
                            quantity = 0
                            onQuantityChange(item, quantity)
                        }
                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Teal900,
                        uncheckedColor = Color.White,
                        checkmarkColor = Color.White
                    ),
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(0.dp)
                )
            }
            Text(
                text = item.productName!!,
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
                fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                fontSize = 14.sp,
            )

            QuantitySelector(
                item = item,
                quantity = quantity,
                onQuantityChange = { newQuantity ->
                    quantity = newQuantity
                    onQuantityChange(item, newQuantity)
                },
                onIncreaseClick = {
                    if (isChecked) {
                        quantity++
                        onQuantityChange(item, quantity)
                    }
                },
                onDecreaseClick = {
                    if (isChecked && quantity > 0) {
                        quantity--
                        onQuantityChange(item, quantity)
                    }
                }
            )
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun ProductItemPreview() {
    ProductItem(
        item = ProductUIModel(
            productName = "Coffee",
            price = 1000,
            imageUrl = "https://www.nespresso.com/ncp/res/uploads/recipes/nespresso-recipes-Latte-Art-Tulip.jpg"
        ),
        onSelectionChange = { _, _ ->

        },
        onQuantityChange = { _, _ ->

        }
    )
}