package com.example.paging3jetpackcomposedemo.screens.home

import androidx.lifecycle.ViewModel
import androidx.paging.ExperimentalPagingApi
import com.example.paging3jetpackcomposedemo.data.repository.Repository
import dagger.Component
import javax.inject.Inject

@ExperimentalPagingApi
class HomeViewModel @Inject constructor(
    repository: Repository
): ViewModel() {
    val getAllImages = repository.getAllImages()
}