package com.ryan.opncodingchallenge.presentation.view.orderSummary.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ryan.opncodingchallenge.presentation.model.ProductUIModel

@Composable
fun CheckoutProductRow(
    list: List<ProductUIModel>,
    onItemClicked: (ProductUIModel) -> Unit
) {
    Column(modifier = Modifier.padding(top = 30.dp, start = 20.dp, end = 20.dp)) {
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            items(list.count()) { index ->
                CheckoutProductItem(item = list[index]) {
                    onItemClicked(it)
                }
            }
        }
    }
}