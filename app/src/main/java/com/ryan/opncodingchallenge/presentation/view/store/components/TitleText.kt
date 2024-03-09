package com.ryan.opncodingchallenge.presentation.view.store.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.ryan.opncodingchallenge.R

@Composable
fun TitleText(modifier: Modifier, title: String) {
    Text(
        text = title,
        fontFamily = FontFamily(
            Font(R.font.urbanist_bold)
        ),
        fontSize = 20.sp,
        modifier = modifier,
    )
}