package com.example.paging3jetpackcomposedemo.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.paging3jetpackcomposedemo.data.local.UnsplashDatabase
import com.example.paging3jetpackcomposedemo.data.paging.UnsplashRemoteMediator
import com.example.paging3jetpackcomposedemo.data.remote.UnsplashApi
import com.example.paging3jetpackcomposedemo.model.UnsplashImage
import com.example.paging3jetpackcomposedemo.util.Constants.ITEM_PER_PAGE
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val unsplashApi: UnsplashApi,
    private val unsplashDatabase: UnsplashDatabase
) {
    @OptIn(ExperimentalPagingApi::class)
    fun getAllImages(): Flow<PagingData<UnsplashImage>> {
        val pagingSourceFactory = { unsplashDatabase.unsplashImageDao().getAllImages() }
        return Pager(
            config = PagingConfig(pageSize = ITEM_PER_PAGE),
            remoteMediator = UnsplashRemoteMediator(
                unsplashApi = unsplashApi,
                unsplashDatabase = unsplashDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }
}