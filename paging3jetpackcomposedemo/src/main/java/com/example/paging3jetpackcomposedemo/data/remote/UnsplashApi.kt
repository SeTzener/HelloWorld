package com.example.paging3jetpackcomposedemo.data.remote

import com.example.paging3jetpackcomposedemo.BuildConfig
import com.example.paging3jetpackcomposedemo.model.UnsplashImage
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UnsplashApi {
    @Headers("Authorization: Client-ID ${BuildConfig.UNSPLASH_API_KEY}")
    @GET("/photos")
    suspend fun getAllImages(
        @Query("page")
        page: Int,
        @Query("per_page")
        perPage: Int
    ): List<UnsplashImage>

    @Headers("Authorization: Client-ID ${BuildConfig.UNSPLASH_API_KEY}")
    @GET("/search/photos")
    suspend fun searchImages(
        @Query("page")
        page: Int,
        @Query("per_page")
        perPage: Int
    ): List<UnsplashImage>
}