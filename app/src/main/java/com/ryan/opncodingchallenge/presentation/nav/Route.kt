package com.ryan.opncodingchallenge.presentation.nav

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ryan.opncodingchallenge.presentation.view.orderSuccess.OrderSuccessView
import com.ryan.opncodingchallenge.presentation.view.orderSummary.OrderSummaryView
import com.ryan.opncodingchallenge.presentation.view.store.StoreView
import com.ryan.opncodingchallenge.presentation.viewmodel.StoreViewModel

@ExperimentalMaterial3Api
@Composable
internal fun Route() {
    val navController = rememberNavController()

    val storeSharedViewModel: StoreViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = Routes.StoreScreen.route) {
        composable(Routes.StoreScreen.route) {
            StoreView(navController = navController, viewModel = storeSharedViewModel)
        }
        composable(Routes.OrderSummaryScreen.route) {
            OrderSummaryView(navController = navController, viewModel = storeSharedViewModel)
        }
        composable(Routes.OrderSuccessScreen.route) {
            OrderSuccessView(navController = navController)
        }
    }
}

sealed class Routes(val route: String) {
    object StoreScreen : Routes("storeScreen")

    object OrderSummaryScreen : Routes("orderSummaryScreen")

    object OrderSuccessScreen : Routes("orderSuccessScreen")
}