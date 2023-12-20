package com.example.paging3jetpackcomposedemo.screens.home

import android.annotation.SuppressLint
import android.app.Application
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.paging.ExperimentalPagingApi
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import com.example.paging3jetpackcomposedemo.navigation.Screen
import com.example.paging3jetpackcomposedemo.screens.common.ListContent


@OptIn(ExperimentalPagingApi::class)
lateinit var homeViewModel: HomeViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalCoilApi
@ExperimentalPagingApi
@Composable
fun HomeScreen (
    navController: NavHostController
) {

    val getAllImages = homeViewModel.getAllImages.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            HomeTopBar(
                onSearchClicked = {
                    navController.navigate(Screen.Search.route)
                }
            )
        },
        content = {
            ListContent(items = getAllImages)
        }
    )
}