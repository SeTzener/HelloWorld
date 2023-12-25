package com.example.paging3jetpackcomposedemo

import android.app.Application
import com.example.paging3jetpackcomposedemo.di.AppComponent
import com.example.paging3jetpackcomposedemo.di.DaggerAppComponent
import javax.inject.Inject

class MyApplication: Application() {
    @Inject lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().applicationContext(this).build()
    }
}