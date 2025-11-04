package com.ayan.boxboxassignmnet.di

import com.ayan.boxboxassignmnet.data.network.BoxBoxApiService
import com.ayan.boxboxassignmnet.utils.AppConstants
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesLoggingInterceptor() = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)
        .setLevel(HttpLoggingInterceptor.Level.HEADERS)

    @Provides
    @Singleton
    fun providesOkHttpClient(interceptor: HttpLoggingInterceptor) = OkHttpClient.Builder()
        .readTimeout(15, TimeUnit.SECONDS)
        .writeTimeout(15, TimeUnit.SECONDS)
        .addNetworkInterceptor(interceptor)
        .build()

    @Provides
    @Singleton
    fun providesRetrofit(client: OkHttpClient) = Retrofit.Builder()
        .baseUrl(AppConstants.BASE_URL)
        .client(client)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun providesBoxBoxApiService(retrofit: Retrofit) = retrofit.create(BoxBoxApiService::class.java)

}