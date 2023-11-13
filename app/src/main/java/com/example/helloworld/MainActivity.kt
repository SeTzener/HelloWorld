package com.example.helloworld

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.ViewConfiguration.get
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlurEffect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.helloworld.data.PersonDao
import com.example.helloworld.data.PersonDbRepository
import com.example.helloworld.di.DatabaseModule.provideDao
import com.example.helloworld.di.DatabaseModule.provideDatabase
import com.example.helloworld.repository.PersonRepository
import com.example.helloworld.ui.theme.HelloWorldTheme
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

class MainActivity : ComponentActivity() {

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
                    roomDatabaseExample(mainViewModel) // To see this uncomment the mainViewModel variable on top
                }
            }
        }
    }
}


@Composable
fun CustomText() {
    Text(
        text = "${stringResource(id = R.string.app_name)} Culo",
        modifier = Modifier
            .background(colorScheme.primary)
            .padding(16.dp),
        color = Color.Magenta,
        fontSize = MaterialTheme.typography.bodyLarge.fontSize
    )
}

@Composable
fun CustomText2() {
    val color = colorScheme.primary
    Text(
        buildAnnotatedString {
            withStyle(style = ParagraphStyle(textAlign = TextAlign.Center)) {
                withStyle(
                    style = SpanStyle(
                        color = color,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("A")
                }
                append("B")
                append("C")
                append("D")
            }
        },
        modifier = Modifier.width(200.dp)
    )
}

@Composable
fun CustomText3() {
    Text(
        text = "Hello World Again!".repeat(20),
        maxLines = 2,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun CustomText4() {
    SelectionContainer {
        Column {
            Text(text = "Hello World 4!")
            DisableSelection {
                Text(text = "Hello World 4!")
            }
            Text(text = "Hello World 4!")
        }
    }
}

@Composable
fun SuperScriptText(
    normalText: String,
    superText: String
) {
    Text(
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = MaterialTheme.typography.titleMedium.fontSize
                )
            ) {
                append(normalText)
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Normal,
                    baselineShift = BaselineShift.Superscript
                )
            ) {
                append(superText)
            }
        }
    )
}

@Composable
fun Greeting() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            Modifier
                .background(Color.Blue)
                .verticalScroll(rememberScrollState()),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
                    .background(Color.Green)
            )
            Text(
                text = "I love android",
                fontSize = 40.sp
            )
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun TextFieldExample() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var text by remember {
            mutableStateOf("Type here...")
        }
        TextField(
            value = text,
            label = { Text(text = "Title") },
            onValueChange = { newText ->
                text = newText
            },
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Email, contentDescription = "Email Icon")
                }
            },
            trailingIcon = {
                IconButton(onClick = { Log.d("Trailing Icon", "Clicked") }) {
                    Icon(imageVector = Icons.Filled.Check, contentDescription = "Email Icon")
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    Log.d("ImeAction", "Clicked")
                }
            )
        )
    }
}

@ExperimentalMaterial3Api
@Composable
fun OutlinedTextFieldExample() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var text by remember {
            mutableStateOf("Type here...")
        }
        OutlinedTextField(
            value = text,
            label = { Text(text = "Title") },
            onValueChange = { newText ->
                text = newText
            },
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Email, contentDescription = "Email Icon")
                }
            },
            trailingIcon = {
                IconButton(onClick = { Log.d("Trailing Icon", "Clicked") }) {
                    Icon(imageVector = Icons.Filled.Check, contentDescription = "Email Icon")
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    Log.d("ImeAction", "Clicked")
                }
            )
        )
    }
}

@Composable
fun CoilImage() {
    Box(
        modifier = Modifier
            .height(400.dp)
            .height(400.dp),
        contentAlignment = Alignment.Center
    ) {
        val painter = rememberAsyncImagePainter(
            ImageRequest.Builder(LocalContext.current)
                .data(data = "https://icon2.cleanpng.com/20180419/wcq/kisspng-rainbow-drawing-vomiting-clip-art-rainbow-night-5ad94480e4ac34.8812463315241882889367.jpg")
                .apply(block = {
                    placeholder(R.drawable.ic_google_logo)
                    error(R.drawable.ic_launcher_foreground)
                    crossfade(1000)
                    transformations(
                        CircleCropTransformation(),
                    )
                }).build()
        )
        val painterState = painter.state
        Image(painter = painter, contentDescription = "Logo Image")
        if (painterState is AsyncImagePainter.State.Loading) {
            CircularProgressIndicator()
        }
    }
}

@Composable
fun PasswordTextFields() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var password by rememberSaveable { mutableStateOf("") }
        var passwordVisibility by remember { mutableStateOf(false) }
        var icon = if (passwordVisibility) {
            painterResource(id = R.drawable.design_ic_visibility)
        } else {
            painterResource(id = R.drawable.design_ic_visibility_off)
        }
        OutlinedTextField(
            value = password,
            visualTransformation = if (passwordVisibility) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            onValueChange = {
                password = it
            },
            placeholder = { Text(text = "Password") },
            trailingIcon = {
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    Icon(
                        painter = icon,
                        contentDescription = "Visibility Icon"
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            )
        )
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