package com.jrblanco.calculadoradejoyeros2021.Home.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.jrblanco.calculadoradejoyeros2021.Home.navigation.HomeScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow<HomeScreenState>(HomeScreenState.Principal)
    val state: StateFlow<HomeScreenState> = _state

    fun handleIntent(intent: HomeScreenIntent) {
        _state.value = when (intent) {
            HomeScreenIntent.SelectPrincipal -> HomeScreenState.Principal
            HomeScreenIntent.SelectOro -> HomeScreenState.NavigationToOro
            HomeScreenIntent.SelectPlata -> HomeScreenState.NavigationToPlata
            HomeScreenIntent.SelectSoldadura -> HomeScreenState.NavigationToSoldadura
            HomeScreenIntent.SelectUtiles -> HomeScreenState.NavigationToUtiles
        }
    }
}