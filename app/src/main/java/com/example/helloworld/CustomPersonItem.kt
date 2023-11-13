package com.example.helloworld

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material3.Text
import com.example.helloworld.model.Person
import com.example.helloworld.repository.PersonRepository

@Composable
fun CustomPersonItem(person: Person) {
    Row(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "${person.age}",
            color = Color.Black,
            fontSize = MaterialTheme.typography.headlineMedium.fontSize,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = person.firstName,
            color = Color.Black,
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            fontWeight = FontWeight.Normal
        )
        Text(
            text = person.lastName,
            color = Color.Black,
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            fontWeight = FontWeight.Normal
        )
    }
}

@Preview
@Composable
fun CustomPersonItemPreview(){
    val personRepository = PersonRepository()
    CustomPersonItem(person = personRepository.getAllData().first())
}