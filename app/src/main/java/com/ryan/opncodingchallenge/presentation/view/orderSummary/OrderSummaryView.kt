package com.ryan.opncodingchallenge.presentation.view.orderSummary

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.ryan.opncodingchallenge.R
import com.ryan.opncodingchallenge.presentation.model.ProductUIModel
import com.ryan.opncodingchallenge.presentation.model.SelectedProduct
import com.ryan.opncodingchallenge.presentation.nav.Routes
import com.ryan.opncodingchallenge.presentation.view.orderSummary.component.CheckoutProductRow
import com.ryan.opncodingchallenge.presentation.view.orderSummary.component.LimitedTextField
import com.ryan.opncodingchallenge.presentation.view.store.components.CheckoutButton
import com.ryan.opncodingchallenge.presentation.view.store.components.DottedLine
import com.ryan.opncodingchallenge.presentation.view.store.components.TitleText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderSummaryView(
    navController: NavHostController
) {

//    val selectedProducts = navController.previousBackStackEntry?.savedStateHandle?.get<List<SelectedProduct>>("products")

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.arrow_backward),
                            contentDescription = "Back",
                            modifier = Modifier
                                .padding(8.dp),
                            contentScale = ContentScale.Fit
                        )
                    }
                }
            )
        },
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
                    .background(Color.White)
            ) {
                ElevatedCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
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
                                navController.navigate(Routes.OrderSuccessScreen.route) { popUpTo(0) }
                            },
                            modifier = Modifier
                                .weight(1f)
                                .padding(end = 20.dp)
                        )
                    }
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
            TitleText(
                modifier = Modifier.padding(start = 20.dp),
                title = "Order Summary"
            )

            CheckoutProductRow(
                list = emptyList(),
                onItemClicked = {

                }
            )

            TitleText(
                modifier = Modifier.padding(start = 20.dp, top = 16.dp),
                title = "Sub Total"
            )

            DottedLine(
                color = Color.Gray,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 20.dp, end = 20.dp)
            )

            TitleText(
                modifier = Modifier.padding(start = 20.dp, top = 21.dp),
                title = "Shipping Address"
            )

            LimitedTextField(
                maxLength = 100,
                modifier = Modifier
                    .padding(start = 20.dp, top = 16.dp)
                    .fillMaxWidth()
            )

        }
    }

}

@Preview(
    showBackground = true
)
@Composable
fun OrderSummaryPreview() {
    OrderSummaryView(
        navController = NavHostController(LocalContext.current)
    )
}