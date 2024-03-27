package com.example.fatihasjcp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.example.fatihasjcp.R.drawable.evilkermit
import com.example.fatihasjcp.R.drawable.guerillakermit
import com.example.fatihasjcp.R.drawable.kermitdying
import com.example.fatihasjcp.R.drawable.kermitfunny
import com.example.fatihasjcp.ui.theme.FatihASJCPTheme
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FatihASJCPTheme(false) {
                MainFunc()
            }
        }
    }
}

@Composable
fun ImageCard(modifier: Modifier = Modifier,
              painterID: Int,
              title: String,
              desc: String = title) {
    Card(
        modifier = modifier
            .requiredWidth(200.dp)
            .requiredHeight(200.dp)
            .padding(16.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
    ){
        Box()
        {
            Image(
                painter = painterResource(id = painterID),
                contentDescription = desc,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f
                        )
                    )
                    .padding(8.dp),
                contentAlignment = Alignment.BottomCenter

            )
            {
                Text(
                    text = title,
                    textAlign = TextAlign.Center,
                    style = TextStyle(color = Color.White, fontSize = 18.sp)
                )
            }
        }
    }
}

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
        text = "Hello, Custom Font!",
        fontFamily = customFont,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun ColorBox(modifier: Modifier = Modifier) {
    val color = remember {
        mutableStateOf(Color(
            Random.nextFloat(),
            Random.nextFloat(),
            Random.nextFloat(),
            1f
        ))
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

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun GreetInput(){
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    var textFieldState by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier
            .padding(1.dp)
            .fillMaxSize()
            .requiredHeight(200.dp),
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp)
        ) {
            TextField(
                value = textFieldState,
                label = { Text("Enter your name", fontSize = 16.sp) },
                onValueChange = { textFieldState = it },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.padding(16.dp))
            Button(
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar("Hello, $textFieldState!")
                    }
                }
            ) {
                Text("Greetings!", fontSize = 16.sp)
            }
        }
    }
}

@Composable
fun LazyLists() {
    LazyColumn{
        itemsIndexed(
            "This is a list of items".split(" ")
        ) { index, item ->
            Text(
                "Item $index: $item",
                fontSize = 24.sp,
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

@Composable
fun ConstraintLayoutExample() {
    val constrains = ConstraintSet {
        val greenBox = createRefFor("greenBox")
        val redBox = createRefFor("redBox")
        val guideline = createGuidelineFromTop(0.5f)

        constrain(greenBox) {
            top.linkTo(guideline)
            start.linkTo(parent.start)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }
        constrain(redBox) {
            top.linkTo(parent.top)
            start.linkTo(greenBox.end)
            width = Dimension.value(100.dp)
            width = Dimension.fillToConstraints
            height = Dimension.value(100.dp)
        }
        createHorizontalChain(greenBox, redBox)
    }
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .background(Color.Green)
                .layoutId("greenBox")
        )
        Box(
            modifier = Modifier
                .background(Color.Red)
                .layoutId("redBox")
        )
    }
}

@Composable
fun MainFunc(){
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
    ) {
        Row {
            GreetInput()
        }
        Row (
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
        )
        {
            ImageCard(
                painterID = evilkermit,
                title = "Evil Kermit")
            ImageCard(
                painterID = kermitdying,
                title = "Kermit Dying")
            ImageCard(
                painterID = kermitfunny,
                title = "Kermit Scrunch Face")
            ImageCard(
                painterID = guerillakermit,
                title = "Guerilla Kermit")
        }
        Row {
            StyledText()
        }
        Row {
            ColorBox()
            ColorBox()
        }
        Row {
            ColorBox()
            ColorBox()
        }
    }
}
