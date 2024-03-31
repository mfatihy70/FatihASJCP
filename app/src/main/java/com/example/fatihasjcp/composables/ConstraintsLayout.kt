package com.example.fatihasjcp.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

@Composable
fun ConstraintsLayout() {
    val screenWidth = LocalConfiguration.current.screenWidthDp.toFloat()
    val constrains = ConstraintSet {
        val greenBox = createRefFor("greenBox")
        val redBox = createRefFor("redBox")
        val guideline = createGuidelineFromStart(0.5f.minus(40.dp.value / screenWidth))

        constrain(greenBox) {
            top.linkTo(parent.top)
            start.linkTo(guideline)
            width = Dimension.value(80.dp)
            height = Dimension.value(80.dp)
        }
        constrain(redBox) {
            top.linkTo(greenBox.bottom)
            start.linkTo(guideline)
            width = Dimension.value(80.dp)
            height = Dimension.value(80.dp)
        }
    }
    ConstraintLayout(
        constrains,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .background(Color.Cyan)
                .layoutId("greenBox")
        )
        Box(
            modifier = Modifier
                .background(Color.Yellow)
                .layoutId("redBox")
        )
    }
}
