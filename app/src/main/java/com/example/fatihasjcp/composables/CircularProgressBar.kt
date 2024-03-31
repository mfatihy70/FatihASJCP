package com.example.fatihasjcp.composables

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CircularProgressBar(percentage: Float) {
    var animationPlayed by remember { mutableStateOf(false) }
    val currentPercentage = animateFloatAsState(
        targetValue = if (animationPlayed) percentage else 0f,
        animationSpec = tween(
            durationMillis = 7000,
            delayMillis = 3), label = "")

    LaunchedEffect (key1 = true){ animationPlayed = true }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(50.dp * 2f),
    ){
        Canvas(modifier = Modifier.size(50.dp * 2f)) {
            drawArc(
                color = Color.Green,
                startAngle = -90f,
                sweepAngle = 360 * currentPercentage.value,
                useCenter = false,
                style = Stroke(width = 8.dp.toPx(), cap = StrokeCap.Round)
            )
        }
        Button(onClick = { animationPlayed = !animationPlayed },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xfffafafa),
                contentColor = Color.Black)
        ){
            Text(
                text = (currentPercentage.value * 100).toInt().toString(),
                fontSize = 28.sp
            )
        }
    }
}
