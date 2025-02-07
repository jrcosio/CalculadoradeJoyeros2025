package com.jrblanco.calculadoradejoyeros2021.Home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.jrblanco.calculadoradejoyeros2021.Home.ui.components.NavigationBarHome
import com.jrblanco.calculadoradejoyeros2021.Home.ui.components.TopBarHome
import com.jrblanco.calculadoradejoyeros2021.Home.ui.viewmodel.HomeScreenViewModel

@Composable
fun HomeScreen(viewModel: HomeScreenViewModel = hiltViewModel()) {

    Scaffold(
        topBar = {
            TopBarHome()
        },
        bottomBar = {
            NavigationBarHome {  }
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(text = "Hello, World!")
        }
    }
}