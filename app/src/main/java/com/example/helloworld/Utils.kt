package com.example.helloworld

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.helloworld.repository.PersonRepository

const val LOREM_IPSUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
        "sed do eiusmod tempor incididunt ut labore et dolore magna " +
        "aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco " +
        "laboris nisi ut aliquip ex ea commodo consequat. Duis aute " +
        "irure dolor in reprehenderit in voluptate velit esse cillum " +
        "dolore eu fugiat nulla pariatur. Excepteur sint occaecat " +
        "cupidatat non proident, sunt in culpa qui officia deserunt " +
        "mollit anim id est laborum."


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun googleButtonAndExpandableCard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .weight(1f)
                .padding(bottom = 16.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {
            GoogleButton()
        }
        Row(
            modifier = Modifier.weight(2f),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center
        ) {
            ExpandableCard("My Title", LOREM_IPSUM)
        }
        Row (
            modifier = Modifier.weight(3f)
        ){
            LazyColumnExample()
        }
    }
}

@Composable
fun CustomText() {
    Text(
        text = "${stringResource(id = R.string.app_name)} Culo",
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp),
        color = Color.Magenta,
        fontSize = MaterialTheme.typography.bodyLarge.fontSize
    )
}

@Composable
fun CustomText2() {
    val color = MaterialTheme.colorScheme.primary
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

@Composable
fun LazyColumnExample() {
    val personRepository = PersonRepository()
    val getAllData = personRepository.getAllData()
    LazyColumn(
        contentPadding = PaddingValues(all = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(items = getAllData){ person ->
            CustomPersonItem(person = person)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyColumnExample2() {
    val sections = listOf("A", "B", "C", "D", "E", "F", "G")
    LazyColumn(
        contentPadding = PaddingValues(all = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        sections.forEach { section ->
            stickyHeader {
                Text(
                   modifier = Modifier
                       .fillMaxSize()
                       .background(Color.LightGray)
                       .padding(12.dp),
                    text = "Section $section"
                )
            }
            items(count = 10){
                Text(
                    modifier = Modifier.padding(5.dp),
                    text ="Item $it from the section $section",
                    color = Color.LightGray
                )
            }
        }
    }
}


@Composable
fun roomDatabaseExample(mainViewModel: MainViewModel){
    val result by mainViewModel.readAllData.collectAsState(initial = emptyList())
    if (result.isNotEmpty()) {
        for (person in result) {
            Text(
                text = person.name,
                color = Color.Green,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize
            )
        }
    } else {
        Text(
            text = "Empty Database",
            fontSize = MaterialTheme.typography.bodyMedium.fontSize
        )
    }
}

@Composable
fun CircularIndicatorExample(){
    var value by remember { mutableIntStateOf(0) }

    CircularIndicator(
        indicatorValue = value
    )

    TextField(
        value = value.toString(),
        onValueChange = {
            value = if (it.isNotEmpty()) {
                it.toInt()
            } else {
                0
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        )
    )
}