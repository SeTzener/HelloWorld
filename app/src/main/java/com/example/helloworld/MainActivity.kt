package com.example.helloworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.helloworld.ui.theme.HelloWorldTheme
import com.example.helloworld.ui.theme.color1
import com.example.helloworld.ui.theme.color2

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController
    private val mainViewModel: MainViewModel by viewModels()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloWorldTheme {
                // A surface container using the 'background' color from the theme

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(colorScheme.background)
                        .padding(24.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
//                    Greeting()
//                    CustomText()
//                    CustomText2()
//                    CustomText3()
//                    CustomText4()
//                    TextFieldExample()
//                    OutlinedTextFieldExample()
//                    googleButtonAndExpandableCard()
//                    CoilImage()
//                    PasswordTextFields()
//                    GradientButton(text = "Button", textColor = Color.White, gradient = Brush.horizontalGradient(colors = listOf(color1, color2))) {}
//                    LazyColumnExample()
//                    LazyColumnExample2()
//                    roomDatabaseExample(mainViewModel) // To see this uncomment the mainViewModel variable on top
//                    CircularIndicatorExample()
                    navController = remember { mutableStateOf}
                }
            }
        }
    }
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HelloWorldTheme {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {

        }
    }
}