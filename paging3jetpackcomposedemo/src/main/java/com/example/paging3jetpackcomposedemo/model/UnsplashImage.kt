package com.example.paging3jetpackcomposedemo.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.paging3jetpackcomposedemo.util.Constants.UNSPLASH_IMAGE_TABLE_NAME
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = UNSPLASH_IMAGE_TABLE_NAME)
data class UnsplashImage (
    @PrimaryKey(autoGenerate = false)
    val id: String,
    @Embedded
    val urls: Urls,
    val likes: Int,
    @Embedded
    val user: User
)

@Serializable
data class Urls(
    @SerialName("regular")
    val regular: String
)

@Serializable
data class User (
    @SerialName("links")
    @Embedded
    val userLinks: UserLinks,
    val userName: String
)

@Serializable
data class UserLinks(
    val html: String
)