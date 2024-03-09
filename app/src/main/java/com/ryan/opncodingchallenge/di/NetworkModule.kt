package com.ryan.opncodingchallenge.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.ryan.opncodingchallenge.data.services.CustomInterceptor
import com.ryan.opncodingchallenge.data.services.StoreApiServices
import com.ryan.opncodingchallenge.util.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Dns
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    @Named("noAuth")
    fun provideNoAuthOkHttpClient(context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .dns(Dns.SYSTEM)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(CustomInterceptor())
            .addInterceptor(ChuckerInterceptor(context))
            .build()
    }

    @Provides
    @Singleton
    @Named("noAuth")
    fun provideNoAuthRetrofit(@Named("noAuth") okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    @Named("noAuth")
    fun provideCommonApiService(@Named("noAuth") retrofit: Retrofit): StoreApiServices {
        return retrofit.create(StoreApiServices::class.java)
    }
}