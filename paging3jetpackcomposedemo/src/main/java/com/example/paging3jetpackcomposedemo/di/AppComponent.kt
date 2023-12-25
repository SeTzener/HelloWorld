package com.example.paging3jetpackcomposedemo.di

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import com.example.paging3jetpackcomposedemo.MainActivity
import com.example.paging3jetpackcomposedemo.screens.home.HomeViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@OptIn(ExperimentalPagingApi::class)
@Component(modules = [DatabaseModule::class, NetworkModule::class, UiModule::class])
@Singleton
interface AppComponent {
    @OptIn(ExperimentalPagingApi::class)
    fun inject(app: MainActivity)

    fun getViewModel() : HomeViewModel

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun applicationContext(applicationContext: Context): Builder
        fun build(): AppComponent
    }
}