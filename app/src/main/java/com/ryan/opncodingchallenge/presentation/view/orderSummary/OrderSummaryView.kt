package com.ryan.opncodingchallenge.presentation.view.orderSummary

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ryan.opncodingchallenge.R
import com.ryan.opncodingchallenge.presentation.common.BottomBar
import com.ryan.opncodingchallenge.presentation.model.ProductUIModel
import com.ryan.opncodingchallenge.presentation.model.SelectedProduct
import com.ryan.opncodingchallenge.presentation.nav.Routes
import com.ryan.opncodingchallenge.presentation.view.orderSummary.component.CheckoutProductRow
import com.ryan.opncodingchallenge.presentation.view.orderSummary.component.LimitedTextField
import com.ryan.opncodingchallenge.presentation.view.store.components.DottedLine
import com.ryan.opncodingchallenge.presentation.view.store.components.TitleTextMedium
import com.ryan.opncodingchallenge.presentation.viewmodel.StoreViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderSummaryView(
    navController: NavHostController,
    viewModel: StoreViewModel
) {
    val selectedProducts = viewModel.selectedProducts.value

    Log.i("basket", "OrderSummary : $selectedProducts")
    val totalAmount = viewModel.totalAmount.value

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
                                .padding(8.dp)
                                .clickable { navController.popBackStack() }, // Navigate back when clicked
                            contentScale = ContentScale.Fit
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(66.dp)
                    .background(Color.White),
                navigateCheckOut = {

                    navController.navigate(Routes.OrderSuccessScreen.route)
                },
                totalAmount = totalAmount
            )
        }
    ) { paddingValue ->
        Column(
            modifier = Modifier
                .padding(paddingValue)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            TitleTextMedium(
                modifier = Modifier.padding(start = 20.dp),
                title = "Order Summary"
            )

            Column(
                modifier = Modifier
                    .size(300.dp)
                    .fillMaxWidth()
                    .padding(start = 20.dp)
            ) {
                CheckoutProductRow(
                    list = selectedProducts,
                    onItemClicked = {

                    }
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.padding(start = 20.dp, top = 21.dp),
                    text = "Sub Total (${selectedProducts.size})",
                    textAlign = TextAlign.Start,
                    fontFamily = FontFamily(
                        Font(R.font.urbanist_bold)
                    ),
                    fontSize = 14.sp,
                )

                Text(
                    modifier = Modifier.padding(end = 20.dp, top = 21.dp),
                    text = "$totalAmount THB",
                    textAlign = TextAlign.Start,
                    fontFamily = FontFamily(
                        Font(R.font.urbanist_medium)
                    ),
                    fontSize = 16.sp,
                )
            }

            DottedLine(
                color = Color.Gray,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 20.dp, end = 20.dp)
            )

            TitleTextMedium(
                modifier = Modifier.padding(start = 20.dp, top = 21.dp),
                title = "Shipping Address"
            )

            LimitedTextField(
                maxLength = 100,
                modifier = Modifier
                    .padding(start = 20.dp, top = 16.dp, end = 20.dp)
                    .fillMaxWidth(1f)
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
        navController = NavHostController(LocalContext.current),
        viewModel = hiltViewModel()
    )
}