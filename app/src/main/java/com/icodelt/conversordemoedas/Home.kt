package com.icodelt.conversordemoedas

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home() {

    var dollar by remember {
        mutableStateOf("")
    }

    var real by remember {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Conversor de Moedas",
                        color = Color.White
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Blue
                )
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "4,98 Real brasileiro",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(20.dp, 100.dp, 0.dp)
            )

            Text(
                text = "12 de mar., 11:27 UTC · Fontes",
                fontSize = 14.sp,
                modifier = Modifier.padding(20.dp, 10.dp, 20.dp, 20.dp)
            )

            OutlinedTextField(
                value = dollar,
                onValueChange = {
                    dollar = it

                    if (dollar.isEmpty()) {
                        dollar = ""
                        real = ""
                    } else {
                        val valorConvertido = dollar.toDouble() * 4.98
                        real = valorConvertido.toString()
                    }
                },
                label = {
                    Text(text = "Dólar americano")
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Blue,
                    unfocusedBorderColor = Color.DarkGray,
                    cursorColor = Color.Blue,
                    focusedLabelColor = Color.DarkGray
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 0.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                textStyle = TextStyle(
                    fontSize = 18.sp
                )
            )

            OutlinedTextField(
                value = real,
                onValueChange = {
                    real = it

                    if (real.isEmpty()) {
                        real = ""
                        dollar = ""
                    } else {
                        val valorConvertido = real.toDouble() / 4.98
                        dollar = valorConvertido.toString()
                    }
                },
                label = {
                    Text(text = "Real brasileiro")
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Blue,
                    unfocusedBorderColor = Color.DarkGray,
                    cursorColor = Color.Blue,
                    focusedLabelColor = Color.DarkGray
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 8.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                textStyle = TextStyle(
                    fontSize = 18.sp
                )
            )
        }
    }
} 