package com.example.paging3jetpackcomposedemo

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import androidx.paging.ExperimentalPagingApi
import coil.annotation.ExperimentalCoilApi
import com.example.paging3jetpackcomposedemo.di.AppComponent
import com.example.paging3jetpackcomposedemo.navigation.SetupNavGraph
import com.example.paging3jetpackcomposedemo.ui.theme.Paging3DemoTheme

val LocalAppComponent = compositionLocalOf<AppComponent> { TODO("Did you forget to initialize it?") }

@ExperimentalPagingApi
class MainActivity : AppCompatActivity() {
    @OptIn(ExperimentalPagingApi::class, ExperimentalCoilApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val myApplication = application as MyApplication
            val component = myApplication.appComponent
            component.inject(this)

            CompositionLocalProvider(LocalAppComponent provides component) {
                Paging3DemoTheme {
                    val navController = rememberNavController()
                    SetupNavGraph(navController = navController)
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        SetupNavGraph(navController = navController)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Paging3DemoTheme {
    }
}