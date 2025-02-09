package com.jrblanco.calculadoradejoyeros2021.Home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.jrblanco.calculadoradejoyeros2021.Home.navigation.HomeScreenState
import com.jrblanco.calculadoradejoyeros2021.Home.navigation.NavigationWrapper
import com.jrblanco.calculadoradejoyeros2021.Home.navigation.Oro
import com.jrblanco.calculadoradejoyeros2021.Home.navigation.Plata
import com.jrblanco.calculadoradejoyeros2021.Home.navigation.Principal
import com.jrblanco.calculadoradejoyeros2021.Home.navigation.Soldadura
import com.jrblanco.calculadoradejoyeros2021.Home.navigation.Utiles
import com.jrblanco.calculadoradejoyeros2021.Home.ui.components.NavigationBarHome
import com.jrblanco.calculadoradejoyeros2021.Home.ui.components.TopBarHome
import com.jrblanco.calculadoradejoyeros2021.Home.ui.viewmodel.HomeScreenIntent
import com.jrblanco.calculadoradejoyeros2021.Home.ui.viewmodel.HomeScreenViewModel

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel(),
    navController: NavHostController
) {

    val state by viewModel.state.collectAsState()

    LaunchedEffect(state) {
        when (state) {
            is HomeScreenState.Principal -> navController.navigate(Principal)
            is HomeScreenState.NavigationToOro -> navController.navigate(Oro)
            is HomeScreenState.NavigationToPlata -> navController.navigate(Plata)
            is HomeScreenState.NavigationToSoldadura -> navController.navigate(Soldadura)
            is HomeScreenState.NavigationToUtiles -> navController.navigate(Utiles)
        }
    }

    Scaffold(
        topBar = { TopBarHome() },
        bottomBar = {
            NavigationBarHome(
                selectedIndex = state.selectedIndex
            ) { index ->
                when (index) {
                    0 -> viewModel.handleIntent(HomeScreenIntent.SelectOro)
                    1 -> viewModel.handleIntent(HomeScreenIntent.SelectPlata)
                    2 -> viewModel.handleIntent(HomeScreenIntent.SelectPrincipal)
                    3 -> viewModel.handleIntent(HomeScreenIntent.SelectSoldadura)
                    4 -> viewModel.handleIntent(HomeScreenIntent.SelectUtiles)
                }

            }
        }
    ) { innerPadding ->
        NavigationWrapper(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            viewModel = viewModel
        )
    }
}