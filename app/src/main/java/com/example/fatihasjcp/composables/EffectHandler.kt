package com.example.fatihasjcp.composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import kotlinx.coroutines.delay

@Composable
fun EffectHandler() {
    val text by remember { mutableStateOf("") }
    LaunchedEffect(key1 = text) {
        delay(1000L)
        println("Text is $text")
    }
}