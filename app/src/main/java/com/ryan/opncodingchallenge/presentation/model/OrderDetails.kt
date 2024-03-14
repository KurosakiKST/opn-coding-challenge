package com.ryan.opncodingchallenge.presentation.model

data class OrderDetails(
    val products: List<ProductUIModel>,
    val deliveryAddress: String
)