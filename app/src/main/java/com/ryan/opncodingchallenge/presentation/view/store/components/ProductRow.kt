package com.ryan.opncodingchallenge.presentation.view.store.components

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
fun ProductRow(
    list: List<ProductUIModel>,
    onSelectionChange: (ProductUIModel, Boolean) -> Unit,
    onQuantityChange: (ProductUIModel, Int) -> Unit
) {
    Column(modifier = Modifier.padding(top = 30.dp, start = 20.dp, end = 20.dp)) {
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            items(list.count()) { index ->
                ProductItem(
                    item = list[index],
                    onSelectionChange = onSelectionChange,
                    onQuantityChange = onQuantityChange
                )
            }
        }
    }
}