package com.ryan.opncodingchallenge.data.dataSource

import com.ryan.opncodingchallenge.domain.model.ProductDomainModel
import com.ryan.opncodingchallenge.domain.model.StoreDomainModel
import com.ryan.opncodingchallenge.presentation.model.OrderDetails
import com.ryan.opncodingchallenge.util.AppResult

interface StoreDataSource {
    suspend fun getStoreData(): AppResult<StoreDomainModel>

    suspend fun getProducts(): AppResult<List<ProductDomainModel>>

    suspend fun makeOrder(orderDetails: OrderDetails): AppResult<Unit>

}