package com.ryan.opncodingchallenge.data.services

import com.ryan.opncodingchallenge.data.responseModel.ProductResponseModel
import com.ryan.opncodingchallenge.data.responseModel.StoreResponseModel
import retrofit2.Response
import retrofit2.http.GET

interface StoreApiServices {
    @GET("storeInfo")
    suspend fun getStoreData(): Response<StoreResponseModel>

    @GET("products")
    suspend fun getProducts(): Response<List<ProductResponseModel>>
}