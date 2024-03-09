package com.ryan.opncodingchallenge.data.remoteDataSource

import android.util.Log
import com.ryan.opncodingchallenge.data.dataSource.StoreDataSource
import com.ryan.opncodingchallenge.data.responseMapper.ProductResponseMapper
import com.ryan.opncodingchallenge.data.responseMapper.StoreResponseMapper
import com.ryan.opncodingchallenge.data.services.StoreApiServices
import com.ryan.opncodingchallenge.domain.model.ProductDomainModel
import com.ryan.opncodingchallenge.domain.model.StoreDomainModel
import com.ryan.opncodingchallenge.util.AppResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Named

class StoreRemoteDataSource @Inject constructor(
    @Named("noAuth") val apiService: StoreApiServices
) : StoreDataSource {
    override suspend fun getStoreData(): AppResult<StoreDomainModel> {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.getStoreData()

                if (response.isSuccessful) {
                    response.body()?.let {
                        val domainModel = StoreResponseMapper.mapToDomainModel(it)
                        AppResult.Success(domainModel)
                    } ?: run {
                        AppResult.Failure(Exception("Error Mapping Response"))
                    }

                } else {
                    AppResult.Failure(Exception("Error Fetching Data"))
                }
            } catch (e: Exception) {
                Log.e("Store error", e.message.toString())
                AppResult.Failure(e)
            }
        }
    }

    override suspend fun getProducts(): AppResult<List<ProductDomainModel>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.getProducts()

                if (response.isSuccessful) {
                    val productList = response.body()?.map { productResponse ->
                        ProductResponseMapper.mapToDomainModel(productResponse)
                    }
                    productList?.let {
                        AppResult.Success(it)
                    } ?: run {
                        AppResult.Failure(Exception("Error Mapping Response"))
                    }
                } else {
                    AppResult.Failure(Exception("Error Fetching Data"))
                }
            } catch (e: Exception) {
                Log.e("Products error", e.message.toString())
                AppResult.Failure(e)
            }
        }
    }

}