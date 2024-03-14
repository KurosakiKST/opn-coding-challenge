package com.ryan.opncodingchallenge.presentation.view.store.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ryan.opncodingchallenge.R

@Composable
fun OpenCloseTimeText(
    modifier: Modifier,
    openingTime: String,
    closingTime: String,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // First two texts aligned to the start
        Text(
            text = "Opening Time : ",
            fontFamily = FontFamily(Font(R.font.urbanist_medium)),
            fontSize = 14.sp,
            modifier = Modifier.weight(1.5f)
        )
        Text(
            text = openingTime,
            fontFamily = FontFamily(Font(R.font.urbanist_bold)),
            fontSize = 14.sp,
            modifier = Modifier.weight(1f)
        )

        // Spacer to create space between the text views
        Spacer(modifier = Modifier.weight(0.1f))

        // Last two texts aligned to the end
        Text(
            text = "Closing Time : ",
            fontFamily = FontFamily(Font(R.font.urbanist_medium)),
            fontSize = 14.sp,
            modifier = Modifier
                .weight(1.5f)
                .wrapContentWidth(align = Alignment.End)
        )
        Text(
            text = closingTime,
            fontFamily = FontFamily(Font(R.font.urbanist_bold)),
            fontSize = 14.sp,
            modifier = Modifier
                .weight(1f)
                .wrapContentWidth(align = Alignment.End)
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
fun OpenCloseTimeTextPreview() {
    OpenCloseTimeText(
        modifier = Modifier,
        openingTime = "12:00AM",
        closingTime = "4:00PM"
    )
}