package com.ryan.opncodingchallenge.presentation.view.orderSummary.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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

@Composable
fun CheckoutProductItem(
    item: ProductUIModel,
    onItemClicked: (ProductUIModel) -> Unit
) {
    Row(
        modifier = Modifier.padding(8.dp)
    ) {
        AsyncImage(
            model = item.imageUrl,
            contentDescription = null,
            placeholder = painterResource(id = R.drawable.placehold_512),
            error = painterResource(id = R.drawable.placehold_512),
            contentScale = ContentScale.Crop,
            modifier = Modifier
        )

        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = item.productName!!,
                modifier = Modifier
                    .fillMaxWidth(),
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
                fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                fontSize = 16.sp,
            )

            Text(
                text = "${item.price} THB",
                fontFamily = FontFamily(Font(R.font.urbanist_medium)),
                fontSize = 14.sp,
            )
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun CheckOutProductItemPreview() {
    CheckoutProductItem(
        item = ProductUIModel("Coffee", 2000, "url"),
        onItemClicked = {}
    )
}