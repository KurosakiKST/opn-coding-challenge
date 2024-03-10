package com.ryan.opncodingchallenge.presentation.view.orderSuccess

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.ryan.opncodingchallenge.R
import com.ryan.opncodingchallenge.presentation.view.store.components.SubText
import com.ryan.opncodingchallenge.presentation.view.store.components.TitleText
import com.ryan.opncodingchallenge.presentation.view.ui.theme.Grey400
import com.ryan.opncodingchallenge.presentation.view.ui.theme.Teal900

@Composable
fun OrderSuccessView(navController: NavHostController) {
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        TitleText(
            modifier = Modifier.padding(8.dp),
            title = "Enjoy Your Order!"
        )

        SubText(
            modifier = Modifier.padding(8.dp),
            title = "Please wait for a moment and we will be there."
        )

        Image(
            painter = painterResource(id = R.drawable.order_summary),
            contentDescription = "Summary Image",
            modifier = Modifier
                .aspectRatio(1.5f)
                .padding(top = 60.dp),
            contentScale = ContentScale.Fit
        )

        Button(
            onClick = {

            },
            modifier = Modifier
                .padding(top = 36.dp, start = 20.dp, end = 20.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Teal900,
                contentColor = Color.White,
                disabledContainerColor = Grey400,
                disabledContentColor = Color.White
            )
        ) {
            Text(text = "Go to Home!")
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun OrderSuccessPreview() {
    OrderSuccessView(navController = NavHostController(LocalContext.current))
}