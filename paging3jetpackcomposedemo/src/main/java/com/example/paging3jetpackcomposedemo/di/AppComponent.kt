package com.example.paging3jetpackcomposedemo.di

import androidx.paging.ExperimentalPagingApi
import com.example.paging3jetpackcomposedemo.MainActivity
import com.example.paging3jetpackcomposedemo.data.repository.Repository
import com.example.paging3jetpackcomposedemo.screens.home.HomeViewModel
import dagger.Component
import javax.inject.Singleton

@OptIn(ExperimentalPagingApi::class)
@Component(modules = [DatabaseModule::class, NetworkModule::class])
interface AppComponent {
    @OptIn(ExperimentalPagingApi::class)
    fun inject(app: MainActivity)
}