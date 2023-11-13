package com.example.helloworld

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
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