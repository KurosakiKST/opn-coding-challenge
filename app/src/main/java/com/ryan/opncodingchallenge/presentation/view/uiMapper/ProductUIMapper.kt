package com.ryan.opncodingchallenge.presentation.view.uiMapper

import com.ryan.opncodingchallenge.domain.model.ProductDomainModel
import com.ryan.opncodingchallenge.presentation.model.ProductUIModel

object ProductUIMapper {
    fun mapToUiModel(domainModel: ProductDomainModel): ProductUIModel {
        return ProductUIModel(
            productName = domainModel.productName ?: "Unavailable",
            price = domainModel.price ?: 0,
            imageUrl = domainModel.imageUrl ?: ""
        )
    }
}