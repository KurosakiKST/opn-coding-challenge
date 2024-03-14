package com.ryan.opncodingchallenge.presentation.view.orderSummary.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ryan.opncodingchallenge.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LimitedTextField(
    maxLength: Int,
    modifier: Modifier
) {
    var text by remember { mutableStateOf(TextFieldValue()) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = { newValue ->
                if (newValue.text.length <= maxLength) {
                    text = newValue
                }
            },
            label = { Text("Label") },
            enabled = true,
            readOnly = false,
            placeholder = {
                Text(text = "placeholder")
            },
            singleLine = false,
            maxLines = 3,
            shape = RoundedCornerShape(12.dp),
        )

        Text(
            text = "${text.text.length}/$maxLength",
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.End)
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
fun PreviewLimitedTextField() {
    LimitedTextField(maxLength = 100, modifier = Modifier)
}