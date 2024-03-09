package com.ryan.opncodingchallenge.data.responseModel

import com.google.gson.annotations.SerializedName

data class ProductResponseModel(
    @SerializedName("name") val productName: String,
    @SerializedName("price") val price: Long,
    @SerializedName("imageUrl") val imageUrl: String,
    @SerializedName("error") val errorData: ErrorData?,
)