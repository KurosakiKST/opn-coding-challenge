package com.ryan.opncodingchallenge.domain.repository

import com.ryan.opncodingchallenge.domain.model.StoreDomainModel
import com.ryan.opncodingchallenge.util.AppResult

interface StoreRepository {
    suspend fun getStoreData(): AppResult<StoreDomainModel>
}