package com.example.paging3jetpackcomposedemo.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Purple500 = Color(0xFF6200EE)
val Pink80 = Color(0xFFEFB8C8)
val HeartRed = Color(0xFFFF4444)

val topAppBarContentColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color.LightGray else Color.White

@OptIn(ExperimentalMaterial3Api::class)
val topAppBarBackgroundColor: TopAppBarColors
    @Composable
    get() = if (isSystemInDarkTheme())
        TopAppBarColors(Color.Black, Color.Black, Color.Black, Color.Black, Color.Black) else
        TopAppBarColors(Purple500, Purple500, Purple500, Purple500, Purple500)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)