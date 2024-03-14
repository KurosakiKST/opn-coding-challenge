package com.ryan.opncodingchallenge.data.responseModel

import com.google.gson.annotations.SerializedName

data class StoreResponseModel(
    @SerializedName("name") val storeName: String?,
    @SerializedName("rating") val rating: Double?,
    @SerializedName("openingTime") val openingTime: String?,
    @SerializedName("closingTime") val closingTime: String?,
    @SerializedName("error") val errorData: ErrorData?,
)

data class ErrorData(
    @SerializedName("name") val errorName: String?,
    @SerializedName("message") val errorMessage: String?,
    @SerializedName("header") val errorHeader: String?,
)
