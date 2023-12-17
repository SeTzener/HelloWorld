package com.example.paging3jetpackcomposedemo.di

import android.content.Context
import androidx.room.Room
import com.example.paging3jetpackcomposedemo.data.local.UnsplashDatabase
import com.example.paging3jetpackcomposedemo.util.Constants.UNSPLASH_DATABASE
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(
        context: Context
    ): UnsplashDatabase {
        return Room.databaseBuilder(
            context,
            UnsplashDatabase::class.java,
            UNSPLASH_DATABASE
        ).build()
    }
}