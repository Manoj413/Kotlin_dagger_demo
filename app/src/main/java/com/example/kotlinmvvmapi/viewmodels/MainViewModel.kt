package com.example.kotlinmvvmapi.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.kotlinmvvmapi.models.Product
import com.example.kotlinmvvmapi.repository.ProductRespository
import com.example.kotlinmvvmapi.utils.ResponseApi
import kotlinx.coroutines.launch

class MainViewModel(private val repository : ProductRespository) : ViewModel() {

    val productLiveData: LiveData<List<Product>>
    get() = repository.products

    fun getProducts(){
        viewModelScope.launch {
           repository.getProducts()
        }
    }
}