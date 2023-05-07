package com.example.kotlinmvvmapi.di

import com.example.kotlinmvvmapi.retrofit.FackerApi
import com.example.kotlinmvvmapi.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit{
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providedFackerApi(retrofit: Retrofit) : FackerApi{
        return retrofit.create(FackerApi::class.java)
    }
}