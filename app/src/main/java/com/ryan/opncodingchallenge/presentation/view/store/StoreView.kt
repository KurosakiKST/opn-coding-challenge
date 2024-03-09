package com.ryan.opncodingchallenge.presentation.view.store

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ryan.opncodingchallenge.R
import com.ryan.opncodingchallenge.presentation.common.ProgressDialog
import com.ryan.opncodingchallenge.presentation.model.ProductUIModel
import com.ryan.opncodingchallenge.presentation.model.StoreUIModel
import com.ryan.opncodingchallenge.presentation.view.store.components.CheckoutButton
import com.ryan.opncodingchallenge.presentation.view.store.components.DottedLine
import com.ryan.opncodingchallenge.presentation.view.store.components.OpenCloseTimeText
import com.ryan.opncodingchallenge.presentation.view.store.components.ProductRow
import com.ryan.opncodingchallenge.presentation.view.store.components.RatingText
import com.ryan.opncodingchallenge.presentation.view.store.components.TitleText
import com.ryan.opncodingchallenge.presentation.viewmodel.StoreViewModel
import com.ryan.opncodingchallenge.util.ViewState
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StoreView(
    navController: NavHostController,
    viewModel: StoreViewModel = hiltViewModel()
) {
    val scope = rememberCoroutineScope()

    var storeData by remember {
        mutableStateOf<StoreUIModel?>(null)
    }

    var productData by remember {
        mutableStateOf<List<ProductUIModel>?>(null)
    }

    var showAlert by remember { mutableStateOf(false) }

    var alertTitle by remember { mutableStateOf("") }
    var alertMsg by remember { mutableStateOf("") }
    var showLoading by remember { mutableStateOf(false) }

    @Composable
    fun showAlert() {
        if (showAlert) {
            AlertDialog(
                onDismissRequest = { },
                title = { Text(text = alertTitle) },
                text = { Text(text = alertMsg) },
                dismissButton = {
                },
                confirmButton = {
                    TextButton(onClick = { showAlert = false }) {
                        Text(text = "OK")
                    }
                },
                modifier = Modifier.clip(RoundedCornerShape(size = 20.dp))
            )
        }

        if (showLoading) {
            ProgressDialog {
                showLoading = false
            }
        }
    }

    LaunchedEffect(Unit) {
        viewModel.getStoreData()
        viewModel.getProducts()
        scope.launch {
            viewModel.storeState.collect {
                when (it) {
                    is ViewState.Error -> {

                        showLoading = false
                        alertTitle = "Error"
                        alertMsg = it.error
                        showAlert = true

                    }

                    ViewState.Loading -> {
                        showLoading = true
                    }

                    ViewState.NoData -> {
                        showLoading = false
                    }

                    is ViewState.Success -> {
                        showLoading = false
                        storeData = it.data
                    }
                }
            }
        }
        scope.launch {
            viewModel.productState.collect {
                when (it) {
                    is ViewState.Error -> {

                        showLoading = false
                        alertTitle = "Error"
                        alertMsg = it.error
                        showAlert = true

                    }

                    ViewState.Loading -> {
                        showLoading = true
                    }

                    ViewState.NoData -> {
                        showLoading = false
                    }

                    is ViewState.Success -> {
                        showLoading = false
                        productData = it.data
                    }
                }
            }
        }
    }
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
                title = storeData?.storeName.toString()
            )

            RatingText(
                modifier = Modifier.padding(start = 20.dp, top = 8.dp),
                ratingNumber = storeData?.rating,
            )

            OpenCloseTimeText(
                modifier = Modifier
                    .padding(start = 20.dp, top = 8.dp, end = 8.dp),
                openingTime = storeData?.openingTime.toString(),
                closingTime = storeData?.closingTime.toString(),
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

            ProductRow(
                list = productData ?: emptyList(),
                onItemClicked = {

                }
            )

            showAlert()

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