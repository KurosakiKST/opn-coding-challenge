package com.ryan.opncodingchallenge.data.services

import com.ryan.opncodingchallenge.data.responseModel.ProductResponseModel
import com.ryan.opncodingchallenge.data.responseModel.StoreResponseModel
import com.ryan.opncodingchallenge.presentation.model.OrderDetails
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface StoreApiServices {
    @GET("storeInfo")
    suspend fun getStoreData(): Response<StoreResponseModel>

    @GET("products")
    suspend fun getProducts(): Response<List<ProductResponseModel>>

    @POST("order")
    suspend fun makeOrder(@Body orderDetails: OrderDetails): Response<Unit>
}