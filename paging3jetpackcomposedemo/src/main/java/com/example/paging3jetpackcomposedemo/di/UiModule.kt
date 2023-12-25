package com.example.paging3jetpackcomposedemo.di

import androidx.paging.ExperimentalPagingApi
import com.example.paging3jetpackcomposedemo.data.repository.Repository
import com.example.paging3jetpackcomposedemo.screens.home.HomeViewModel
import dagger.Module
import dagger.Provides

@Module
class UiModule {
    @OptIn(ExperimentalPagingApi::class)
    @Provides
    fun provideHomeViewModel(repository: Repository): HomeViewModel = HomeViewModel(repository)
}