package com.jrblanco.calculadoradejoyeros2021.Home.ui.viewmodel

sealed class HomeScreenIntent {
    object SelectPrincipal : HomeScreenIntent()
    object SelectOro : HomeScreenIntent()
    object SelectPlata : HomeScreenIntent()
    object SelectSoldadura : HomeScreenIntent()
    object SelectUtiles : HomeScreenIntent()
}