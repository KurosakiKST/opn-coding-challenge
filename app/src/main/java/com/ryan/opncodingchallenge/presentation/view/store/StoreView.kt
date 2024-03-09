package com.ryan.opncodingchallenge.presentation.view.store

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentComposer
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.core.content.res.FontResourcesParserCompat
import androidx.navigation.NavHostController
import com.ryan.opncodingchallenge.R
import com.ryan.opncodingchallenge.presentation.view.store.components.BottomCheckout
import com.ryan.opncodingchallenge.presentation.view.store.components.CheckoutButton
import com.ryan.opncodingchallenge.presentation.view.store.components.DottedLine
import com.ryan.opncodingchallenge.presentation.view.store.components.RatingText
import com.ryan.opncodingchallenge.presentation.view.store.components.TitleText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StoreView(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 59.dp, horizontal = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "Enjoy Your Order!",
                            fontFamily = FontFamily(
                                Font(R.font.urbanist_bold)
                            )
                        )
                    }
                }

            )
        },
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .height(64.dp) // Set your desired height
                    .background(Color.White)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Total: 0 THB",
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 20.dp)
                    )
                    CheckoutButton(
                        onClick = {

                        },
                        modifier = Modifier
                            .padding(end = 20.dp)
                    )
                }
            }
        }
    ) { paddingValue ->
        Column(
            modifier = Modifier
                .padding(paddingValue)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Image(
                painter = painterResource(id = R.drawable.store_cover),
                contentDescription = "Cover Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(2f)
                    .padding(top = 8.dp),
                contentScale = ContentScale.Fit
            )

            TitleText(
                modifier = Modifier.padding(start = 20.dp, top = 24.dp),
                title = "The Coffee Shop!"
            )

            RatingText(
                modifier = Modifier.padding(start = 20.dp, top = 8.dp),
                ratingNumber = 24,
            )

            DottedLine(
                color = Color.Gray,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 20.dp, end = 20.dp)
            )

            TitleText(
                modifier = Modifier.padding(start = 20.dp, top = 24.dp),
                title = "Explore Menu"
            )


        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun StorePreview() {
    StoreView(navController = NavHostController(LocalContext.current))
}