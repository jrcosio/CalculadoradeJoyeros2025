package com.jrblanco.calculadoradejoyeros2021.Home.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jrblanco.calculadoradejoyeros2021.Home.ui.viewmodel.HomeScreenViewModel
import com.jrblanco.calculadoradejoyeros2021.Oro.OroScreen
import com.jrblanco.calculadoradejoyeros2021.Plata.PlataScreen
import com.jrblanco.calculadoradejoyeros2021.Principal.PrincipalScreen
import com.jrblanco.calculadoradejoyeros2021.Soldadura.SoldaduraScreen
import com.jrblanco.calculadoradejoyeros2021.Utiles.UtilesScreen

@Composable
fun NavigationWrapper(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: HomeScreenViewModel
) {


    NavHost(
        navController = navController,
        startDestination = Principal
    ) {
        composable<Principal> {
            PrincipalScreen(modifier = modifier, onNavigate = viewModel::handleIntent)
        }
        composable<Oro> {
            OroScreen(modifier = modifier)
        }
        composable<Plata> {
            PlataScreen(modifier = modifier)
        }
        composable<Soldadura> {
            SoldaduraScreen(modifier = modifier)
        }
        composable<Utiles> {
            UtilesScreen(modifier = modifier)
        }
    }

}