package com.example.fatihasjcp.composables

import android.view.MotionEvent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import com.example.fatihasjcp.R
import kotlin.math.PI
import kotlin.math.atan2

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MusicKnob(
    limitingAngle: Float = 25f,
    onValueChange: (Float) -> Unit
){
    var rotation by remember { mutableFloatStateOf(limitingAngle) }
    var touchX by remember { mutableFloatStateOf(0f) }
    var touchY by remember { mutableFloatStateOf(0f) }
    var centerX by remember { mutableFloatStateOf(0f) }
    var centerY by remember { mutableFloatStateOf(0f) }

    Image(painter = painterResource(id = R.drawable.knob),
        contentDescription = "Knob",
        modifier = Modifier
            .fillMaxSize()
            .onGloballyPositioned {
                val windowBounds = it.boundsInWindow()
                centerX = windowBounds.size.width / 2
                centerY = windowBounds.size.height / 2
            }
            .pointerInteropFilter { event ->
                touchX = event.x
                touchY = event.y
                val angle =
                    -atan2(centerY - touchY, touchX - centerX) *
                            (PI / 180f).toFloat()


                when (event.action) {
                    MotionEvent.ACTION_MOVE -> {
                        if (angle !in -limitingAngle..limitingAngle) {
                            val fixedAngle = if (angle in -180f..-limitingAngle) {
                                360f + angle
                            } else {
                                angle
                            }
                            rotation = fixedAngle
                            val percent = (rotation + limitingAngle) / (360f - 2 * limitingAngle)
                            onValueChange(percent)
                            true
                        } else false
                    }

                    else -> false
                }
            }
            .rotate(rotation)
    )
}

@Composable
fun VolumeBar(
    modifier: Modifier = Modifier,
    activeBars: Int = 0,
    totalBars: Int = 10
){
    BoxWithConstraints (
        contentAlignment = Alignment.Center,
        modifier = modifier)
    {

        val barWidth = remember { maxWidth / (2f * totalBars) }
        Canvas(modifier = Modifier) {
            for (i in 0 until totalBars) {
                drawRoundRect(
                    color = if (i in 0 until activeBars) Color.Black else Color.Gray,
                    topLeft = Offset(i.toFloat() * barWidth.value * 2f + barWidth.value / 2f, 0f),
                    size = Size(barWidth.value, size.height),
                    cornerRadius = CornerRadius(0f)
                )
            }
        }
    }
}