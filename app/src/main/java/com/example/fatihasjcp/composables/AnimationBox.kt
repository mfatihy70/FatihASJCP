package com.example.fatihasjcp.composables

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AnimationBox() {

    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    var sizeState by remember { mutableStateOf(200.dp) }
    var text by remember { mutableStateOf("Bigger") }

    val size by animateDpAsState(
        targetValue = sizeState,
        spring(Spring.DampingRatioHighBouncy, stiffness = 1000f),
        label = ""
    )
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val color by infiniteTransition.animateColor(
        initialValue = Color.Red,
        targetValue = Color.Blue,
        animationSpec = infiniteRepeatable(
            tween(durationMillis = 2000),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    Box(
        modifier = Modifier
            .size(size)
            .padding(16.dp)
            .background(color),

        contentAlignment = Alignment.Center)
    {
        Button(onClick = {
            text = "Bigger"
            if (sizeState > screenWidth) {
                sizeState = 200.dp
            } else {
                sizeState += 50.dp
            }
            if (sizeState > screenWidth) {
                text = "Now Smaller"
            }
        },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black)
        )
        {
            Text(fontSize = 16.sp, text = text)
        }
    }
}
