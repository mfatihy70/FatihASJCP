package com.example.fatihasjcp.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Composable
fun ColorBox(modifier: Modifier = Modifier) {
    val color = remember {
        mutableStateOf(
            Color(
            Random.nextFloat(),
            Random.nextFloat(),
            Random.nextFloat(),
            1f
        )
        )
    }
    Box(
        modifier = modifier
            .requiredWidth(200.dp)
            .requiredHeight(200.dp)
            .padding(16.dp)
            .background(color.value)
            .clickable {
                color.value = Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    1f
                )
            }
    )
}
