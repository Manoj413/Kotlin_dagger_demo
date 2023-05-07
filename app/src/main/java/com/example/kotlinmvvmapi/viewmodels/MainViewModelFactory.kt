package com.example.kotlinmvvmapi.viewmodels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinmvvmapi.repository.ProductRespository
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(private val repository : ProductRespository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}