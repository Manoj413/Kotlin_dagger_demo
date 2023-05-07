package com.example.kotlinmvvmapi.utils

import kotlinx.coroutines.*

class Util(val dispatcher:CoroutineDispatcher) {

    suspend fun getUserList():String{
        delay(1000)
        return "Sample_KotlinMvvm"
    }

    suspend fun getMainUserList():String{
        CoroutineScope(Dispatchers.Main).launch {
            delay(1000)
        }
        return "Sample_KorlinMavvmOnMainThread"
    }

    suspend fun getAddress():String{
        withContext(dispatcher){
            delay(1000)
        }
        return "My_Address"
    }

    var globalArg = false
    fun getAddressDetail() : Boolean {
        CoroutineScope(dispatcher).launch {
            globalArg = true
        }
        return globalArg
    }

}