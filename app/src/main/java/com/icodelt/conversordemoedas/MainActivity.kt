package com.icodelt.conversordemoedas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.icodelt.conversordemoedas.ui.theme.ConversorDeMoedasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConversorDeMoedasTheme {
                Home()
            }
        }
    }
}
