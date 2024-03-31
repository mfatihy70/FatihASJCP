package com.example.fatihasjcp.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fatihasjcp.R

@Composable
fun StyledText() {
    val customFont = FontFamily(
        Font(R.font.comicneue_bold, FontWeight.Bold, FontStyle.Normal),
        Font(R.font.comicneue_regular, FontWeight.Normal, FontStyle.Normal),
        Font(R.font.comicneue_italic, FontWeight.Normal, FontStyle.Italic),
        Font(R.font.comicneue_bolditalic, FontWeight.Bold, FontStyle.Italic),
        Font(R.font.comicneue_light, FontWeight.Light, FontStyle.Normal),
        Font(R.font.comicneue_lightitalic, FontWeight.Light, FontStyle.Italic)
    )
    Text(
        text = "Hello, this is the font Comic Neue!",
        fontFamily = customFont,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        modifier = Modifier.padding(16.dp)
    )
}
