package com.jrblanco.calculadoradejoyeros2021.Home.ui.components

import android.widget.Toolbar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarHome() {
    TopAppBar(
        title = { Text(text = "Calculadora de Joyeros") },
    )
}
