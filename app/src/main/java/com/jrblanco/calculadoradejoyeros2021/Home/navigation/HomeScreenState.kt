package com.jrblanco.calculadoradejoyeros2021.Home.navigation

sealed class HomeScreenState(val selectedIndex: Int) {
    object NavigationToOro : HomeScreenState(0)
    object NavigationToPlata : HomeScreenState(1)
    object Principal : HomeScreenState(2)
    object NavigationToSoldadura : HomeScreenState(3)
    object NavigationToUtiles : HomeScreenState(4)
}
