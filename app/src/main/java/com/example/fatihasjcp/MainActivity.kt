package com.example.fatihasjcp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.fatihasjcp.R.drawable.evilkermit
import com.example.fatihasjcp.R.drawable.guerillakermit
import com.example.fatihasjcp.R.drawable.kermitdying
import com.example.fatihasjcp.R.drawable.kermitfunny
import com.example.fatihasjcp.composables.AnimationBox
import com.example.fatihasjcp.composables.CircularProgressBar
import com.example.fatihasjcp.composables.ColorBox
import com.example.fatihasjcp.composables.ConstraintsLayout
import com.example.fatihasjcp.composables.GreetInput
import com.example.fatihasjcp.composables.ImageCard
import com.example.fatihasjcp.composables.LazyLists
import com.example.fatihasjcp.composables.MusicKnob
import com.example.fatihasjcp.composables.StyledText
import com.example.fatihasjcp.composables.VolumeBar
import com.example.fatihasjcp.ui.theme.FatihASJCPTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FatihASJCPTheme(false) {
                ConstraintsLayout()
                LazyLists()
                Column(
                    modifier = Modifier.verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row {
                        Box(
                            contentAlignment = Alignment.CenterEnd,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(30.dp)
                        ) {
                            CircularProgressBar(percentage = 0.99f)
                        }
                    }
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        AnimationBox()
                    }
                    Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                        ImageCard(painterID = evilkermit, title = "Evil Kermit")
                        ImageCard(painterID = kermitdying, title = "Kermit Dying")
                        ImageCard(painterID = kermitfunny, title = "Kermit Scrunch Face")
                        ImageCard(painterID = guerillakermit, title = "Guerilla Kermit")
                    }
                    Row { StyledText() }
                    Row { ColorBox(); ColorBox() }
                    Row {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color(0xffc5ffbf)),
                            contentAlignment = Alignment.Center
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .padding(16.dp)
                                    .size(200.dp)
                                    .background(Color(0xfffcaeae))
                            ) {
                                var volume by remember { mutableFloatStateOf(0f) }
                                var totalBars by remember { mutableIntStateOf(20) }
                                MusicKnob {
                                    volume = it
                                    totalBars = (it * 20).toInt()
                                }
                                Spacer(modifier = Modifier.width(20.dp))
                                VolumeBar(
                                    activeBars = (totalBars * volume).toInt(),
                                    totalBars = totalBars
                                )
                            }
                        }
                    }
                    Row { GreetInput() }
                }
            }
        }
    }
}