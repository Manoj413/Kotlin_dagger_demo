package com.example.kotlinmvvmapi.retrofit

import com.example.kotlinmvvmapi.models.Product
import retrofit2.Response
import retrofit2.http.GET

interface FackerApi {

    @GET("products")
    suspend fun getProducts() : Response<List<Product>>
}