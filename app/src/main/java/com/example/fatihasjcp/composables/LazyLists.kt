package com.example.fatihasjcp.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LazyLists() {
    LazyColumn(modifier = Modifier.padding(16.dp)){
        itemsIndexed(
            "This is a list of items".split(" ")
        ) { index, item ->
            Text(
                "Item $index: $item",
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
        /*items(10){
            Text("Item $it", fontSize = 24.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center)
        }*/
    }
}
