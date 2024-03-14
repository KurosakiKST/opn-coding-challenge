package com.ryan.opncodingchallenge.presentation.view.orderSummary.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ryan.opncodingchallenge.presentation.model.ProductUIModel
import com.ryan.opncodingchallenge.presentation.model.SelectedProduct

@Composable
fun CheckoutProductRow(
    list: List<SelectedProduct>,
    onItemClicked: (SelectedProduct) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        items(list) { product ->
            CheckoutProductItem(item = product, onItemClicked = onItemClicked)
        }
    }
}


@Preview(
    showBackground = true
)
@Composable
fun CheckoutProductRowPreview() {
    val selectedProducts: List<SelectedProduct> = listOf(
        SelectedProduct(
            product = ProductUIModel(
                productName = "Latte",
                price = 50,
                imageUrl = "https://www.nespresso.com/ncp/res/uploads/recipes/nespresso-recipes-Latte-Art-Tulip.jpg"
            ),
            quantity = 2
        ),
        SelectedProduct(
            product = ProductUIModel(
                productName = "Dark Tiramisu Mocha",
                price = 75,
                imageUrl = "https://www.nespresso.com/shared_res/mos/free_html/sg/b2b/b2ccoffeerecipes/listing-image/image/dark-tiramisu-mocha.jpg"
            ),
            quantity = 2
        )
    )
    CheckoutProductRow(
        list = selectedProducts,
        onItemClicked = {}
    )
}