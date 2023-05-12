package com.example.vasundharatest.di

import com.example.vasundharatest.remote.RestApi
import com.example.vasundharatest.repository.AppDetailRepository
import com.example.vasundharatest.repository.AppDetailsRepositoryImplementation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun getUrl(): String =
        "https://vasundharaapps.com/artwork_apps/api/AdvertiseNewApplications/17/"

    @Provides
    @Singleton
    fun okHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    @Provides
    @Singleton
    fun retrofit(): Retrofit = Retrofit.Builder().baseUrl(getUrl()).client(okHttpClient())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create()).build()

    @Provides
    @Singleton
    fun myApi():RestApi=retrofit().create(RestApi::class.java)

    @Provides
    @Singleton
    fun repository(api:RestApi):AppDetailRepository=AppDetailsRepositoryImplementation(api)

}