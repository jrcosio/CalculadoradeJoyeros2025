package com.jrblanco.calculadoradejoyeros2021.Home.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jrblanco.calculadoradejoyeros2021.Principal.PrincipalScreen

@Composable
fun NavigationWrapper(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Principal
    ) {
        composable<Principal> {
            PrincipalScreen(modifier = modifier)
        }
    }

}