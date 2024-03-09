package com.ryan.opncodingchallenge.presentation.view.store.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ryan.opncodingchallenge.R

@Composable
fun RatingText(modifier: Modifier, ratingNumber: Int) {
    Row(
        modifier = modifier
    ) {
        Text(
            text = ratingNumber.toString(),
            fontFamily = FontFamily(Font(R.font.urbanist_bold)),
            fontSize = 14.sp,
            modifier = Modifier.padding(end = 4.dp)
        )
        Text(
            text = "Ratings",
            fontFamily = FontFamily(Font(R.font.urbanist_medium)),
            fontSize = 14.sp,
            modifier = Modifier.padding(end = 16.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.arrow_forward),
            contentDescription = "forwar Arrow",
            modifier = Modifier.size(size = 18.dp)
        )
    }

}

@Preview(
    showBackground = true
)
@Composable
fun RatingTextPreview() {
    RatingText(
        modifier = Modifier,
        ratingNumber = 24
    )
}