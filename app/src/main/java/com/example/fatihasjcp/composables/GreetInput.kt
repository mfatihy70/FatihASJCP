package com.example.fatihasjcp.composables

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material3.Button
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

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
