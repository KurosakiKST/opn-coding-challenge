package com.ryan.opncodingchallenge.domain.usecase

import com.ryan.opncodingchallenge.domain.model.ProductDomainModel
import com.ryan.opncodingchallenge.domain.model.StoreDomainModel
import com.ryan.opncodingchallenge.domain.repository.StoreRepository
import com.ryan.opncodingchallenge.presentation.model.OrderDetails
import com.ryan.opncodingchallenge.util.AppResult
import javax.inject.Inject

class StoreUseCase @Inject constructor(
    private val storeRepository: StoreRepository
) {
    suspend fun getStoreData(): AppResult<StoreDomainModel> {
        return storeRepository.getStoreData()
    }

    suspend fun getProducts(): AppResult<List<ProductDomainModel>> {
        return storeRepository.getProducts()
    }

    suspend fun makeOrder(orderDetails: OrderDetails): AppResult<Unit> {
        return storeRepository.makeOrder(orderDetails)
    }
}