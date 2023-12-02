package com.example.helloworld.circular.shape.image.example

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.helloworld.R

@Composable
fun CircularImageScreen() {
    Column {
        Image(
            modifier = Modifier
                .size(300.dp)
                .clip(CircleShape),
            painter = painterResource(id = R.drawable.tano_profile_pic),
            contentDescription = "Circular Image"
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Image(
            modifier = Modifier
                .size(300.dp)
                .clip(RoundedCornerShape(size = 50.dp))
                .border(
                    width = 10.dp,
                    color = Color.Yellow,
                    shape = RoundedCornerShape(size = 50.dp)
                ),
            painter = painterResource(id = R.drawable.tano_profile_pic),
            contentDescription = "Circular Image"
        )
    }
}

@Composable
@Preview(showBackground = true)
fun CircularImageScreenPreview() {
    CircularImageScreen()
}