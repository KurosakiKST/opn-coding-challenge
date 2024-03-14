package com.ryan.opncodingchallenge.data.responseMapper

import com.ryan.opncodingchallenge.data.responseModel.ProductResponseModel
import com.ryan.opncodingchallenge.domain.model.ProductDomainModel

object ProductResponseMapper {
    fun mapToDomainModel(response: ProductResponseModel): ProductDomainModel {
        return ProductDomainModel(
            productName = response.productName,
            price = response.price,
            imageUrl = response.imageUrl
        )
    }
}