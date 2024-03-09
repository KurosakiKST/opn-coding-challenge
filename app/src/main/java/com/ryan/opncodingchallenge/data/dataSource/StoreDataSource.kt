package com.ryan.opncodingchallenge.data.dataSource

import com.ryan.opncodingchallenge.domain.model.StoreDomainModel
import com.ryan.opncodingchallenge.util.AppResult

interface StoreDataSource {
    suspend fun getStoreData(): AppResult<StoreDomainModel>

}