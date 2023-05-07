package com.example.kotlinmvvmapi.repository

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlinmvvmapi.BuildConfig.DEBUG
import com.example.kotlinmvvmapi.models.Product
import com.example.kotlinmvvmapi.retrofit.FackerApi
import com.example.kotlinmvvmapi.utils.ResponseApi
import javax.inject.Inject

class ProductRespository @Inject constructor(private val fackerApi: FackerApi) {
    private val _products = MutableLiveData<List<Product>>()
     val products: LiveData<List<Product>>
         get()= _products

    suspend fun getProducts() : ResponseApi<List<Product>>{
         val result = fackerApi.getProducts()
        Log.e("ProductRepo_1", fackerApi.getProducts().toString())

        return if (result.isSuccessful) {
            val responseBody = result.body()
            _products.postValue(responseBody)
            if (responseBody != null) {
                ResponseApi.Success(responseBody)
            } else {
                ResponseApi.Error("Something went wrong")
            }
        }else{
            ResponseApi.Error("Something went wrong")
        }

        /*if (result.isSuccessful && result.body()!=null){
            println("ProductRepo_2 = "+result.body())

            _products.postValue(result.body())
        }*/
    }
}