package com.example.paging3jetpackcomposedemo.screens.home

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.provider.Contacts
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.paging3jetpackcomposedemo.ui.theme.topAppBarBackgroundColor
import com.example.paging3jetpackcomposedemo.ui.theme.topAppBarContentColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(
    onSearchClicked: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = "Home",
                color = topAppBarContentColor
            )
        },
        colors = topAppBarBackgroundColor,
        actions = {
            IconButton(onClick = onSearchClicked) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon",
                    tint = Color.White
                )
            }
        }
    )
}

@Composable
@Preview(showBackground = true)
fun HomeTopBarPreview() {
    HomeTopBar { }
}

@Composable
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
fun HomeTopBarPreviewBright() {
    HomeTopBar { }
}