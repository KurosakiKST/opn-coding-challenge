package com.ryan.opncodingchallenge.data.repoImpl

import com.ryan.opncodingchallenge.data.dataSource.StoreDataSource
import com.ryan.opncodingchallenge.domain.model.StoreDomainModel
import com.ryan.opncodingchallenge.domain.repository.StoreRepository
import com.ryan.opncodingchallenge.util.AppResult
import javax.inject.Inject

class StoreRepoImpl @Inject constructor(
    private val storeDataSource: StoreDataSource
) : StoreRepository {
    override suspend fun getStoreData(): AppResult<StoreDomainModel> {
        return storeDataSource.getStoreData()
    }

}