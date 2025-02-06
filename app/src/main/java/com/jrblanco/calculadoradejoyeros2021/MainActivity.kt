package com.jrblanco.calculadoradejoyeros2021

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.jrblanco.calculadoradejoyeros2021.Home.HomeScreen
import com.jrblanco.calculadoradejoyeros2021.ui.theme.CalculadoraDeJoyerosTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculadoraDeJoyerosTheme {
                HomeScreen()
            }
        }
    }
}

