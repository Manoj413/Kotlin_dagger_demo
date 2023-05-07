package com.example.kotlinmvvmapi.utils

sealed class ResponseApi<T>(val data:T?=null,val message:String?=null){
    class Success<T>(data: T) : ResponseApi<T>(data)
    class Error<T>(message: String?,data: T?=null) : ResponseApi<T>(data,message)
    class Loading<T> : ResponseApi<T>()
}
