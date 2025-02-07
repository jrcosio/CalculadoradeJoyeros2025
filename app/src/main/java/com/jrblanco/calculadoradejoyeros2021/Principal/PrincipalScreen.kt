package com.jrblanco.calculadoradejoyeros2021.Principal

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PrincipalScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        SeccionPrincipal() { }
        SeccionPrincipal() { }
    }
}

@Composable
fun SeccionPrincipal(modifier: Modifier = Modifier, onClick: () -> Unit) {

    Card(modifier = modifier
        .fillMaxWidth()
        .padding(horizontal = 8.dp, vertical = 4.dp)
        .clickable { onClick() },
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Blue,
            contentColor = Color.White
        ),
    ) {
        Text(
            text = "Principal",
            modifier = Modifier.padding(16.dp),
            color = Color.Black
        )
    }
}
