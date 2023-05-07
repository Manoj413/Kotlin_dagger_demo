package com.example.kotlinmvvmapi

import android.app.Application
import com.example.kotlinmvvmapi.di.ApplicationComponent
import com.example.kotlinmvvmapi.di.DaggerApplicationComponent


class FackerApplication : Application() {
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder().build()


    }

}