package com.example.paging3jetpackcomposedemo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.paging3jetpackcomposedemo.data.local.dao.UnsplashImageDao
import com.example.paging3jetpackcomposedemo.data.local.dao.UnsplashRemoteKeysDao
import com.example.paging3jetpackcomposedemo.model.UnsplashImage
import com.example.paging3jetpackcomposedemo.model.UnsplashRemoteKeys

@Database(entities = [UnsplashImage::class, UnsplashRemoteKeys::class], version = 1)
abstract class UnsplashDatabase: RoomDatabase() {
    abstract fun unsplashImageDao(): UnsplashImageDao
    abstract fun unsplashRemoteKeysDao(): UnsplashRemoteKeysDao
}