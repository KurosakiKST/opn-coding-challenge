package com.ryan.opncodingchallenge.di

import com.ryan.opncodingchallenge.data.dataSource.StoreDataSource
import com.ryan.opncodingchallenge.data.remoteDataSource.StoreRemoteDataSource
import com.ryan.opncodingchallenge.data.repoImpl.StoreRepoImpl
import com.ryan.opncodingchallenge.domain.repository.StoreRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AbstractModule {

    /**-------DataSources--------*/
    @Binds
    abstract fun provideStoreDataSource(storeDataSource: StoreRemoteDataSource): StoreDataSource

    /**-------Repositories-------*/
    @Binds
    abstract fun storeRepository(storeRepoImpl: StoreRepoImpl): StoreRepository
}