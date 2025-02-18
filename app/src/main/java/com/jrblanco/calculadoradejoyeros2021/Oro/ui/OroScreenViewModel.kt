package com.jrblanco.calculadoradejoyeros2021.Oro.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class OroEstados(
    val tipoDeOro: String = "",
    val tipoDeAleacion: String = "",
    val gramosDeOroPuro: String = ""
)


@HiltViewModel
class OroScreenViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow<OroEstados>(OroEstados())
    val state: StateFlow<OroEstados> = _state

    fun seleccionarTipoDeOro(tipoDeOro: String) {
        _state.value = _state.value.copy(tipoDeOro = tipoDeOro)
    }

    fun seleccionarTipoDeAleacion(tipoDeAleacion: String) {
        _state.value = _state.value.copy(tipoDeAleacion = tipoDeAleacion)
    }

    fun seleccionarGramosDeOroPuro(gramosDeOroPuro: String) {
        _state.value = _state.value.copy(gramosDeOroPuro = gramosDeOroPuro)
    }

}