package com.example.paging3jetpackcomposedemo.di

import androidx.paging.ExperimentalPagingApi
import com.example.paging3jetpackcomposedemo.MyApplication
import dagger.Component

@Component(modules = [DatabaseModule::class, NetworkModule::class])
interface AppComponent {
    @OptIn(ExperimentalPagingApi::class)
    fun inject(app: MyApplication)
}
