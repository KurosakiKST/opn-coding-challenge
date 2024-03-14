package com.ryan.opncodingchallenge.data.responseMapper

import com.ryan.opncodingchallenge.data.responseModel.StoreResponseModel
import com.ryan.opncodingchallenge.domain.model.StoreDomainModel

object StoreResponseMapper {
    fun mapToDomainModel(response: StoreResponseModel): StoreDomainModel {
        return StoreDomainModel(
            storeName = response.storeName,
            rating = response.rating,
            openingTime = response.openingTime,
            closingTime = response.closingTime
        )
    }
}