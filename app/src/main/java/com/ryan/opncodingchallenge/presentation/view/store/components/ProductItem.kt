package com.ryan.opncodingchallenge.presentation.view.store.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.ryan.opncodingchallenge.R
import com.ryan.opncodingchallenge.presentation.model.ProductUIModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductItem(
    item: ProductUIModel,
    onItemClicked: (ProductUIModel) -> Unit
) {
    ElevatedCard(
        onClick = { onItemClicked(item) },
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
                ElevatedCard(
                    modifier = Modifier.fillMaxSize(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    shape = RoundedCornerShape(5.dp)
                ) {
                    AsyncImage(
                        model = item.imageUrl,
                        contentDescription = null,
                        placeholder = painterResource(id = R.drawable.placehold_512),
                        error = painterResource(id = R.drawable.placehold_512),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
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
            }
        }
    }
}