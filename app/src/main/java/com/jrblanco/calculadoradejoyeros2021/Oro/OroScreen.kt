package com.jrblanco.calculadoradejoyeros2021.Oro

import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jrblanco.calculadoradejoyeros2021.Oro.ui.data.AleacionesDeOro
import com.jrblanco.calculadoradejoyeros2021.Oro.ui.OroScreenViewModel
import com.jrblanco.calculadoradejoyeros2021.Oro.ui.data.TiposDeOro
import com.jrblanco.calculadoradejoyeros2021.Oro.ui.componentes.CardOro
import com.jrblanco.calculadoradejoyeros2021.Oro.ui.componentes.CardQuilates


@Composable
fun OroScreen(
    modifier: Modifier = Modifier,
    viewModel: OroScreenViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            repeat(TiposDeOro.size) {
                CardOro(TiposDeOro[it], state.tipoDeOro) { tipoDeOro ->
                    viewModel.seleccionarTipoDeOro(tipoDeOro)
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            repeat(AleacionesDeOro.size) {
                CardQuilates(AleacionesDeOro[it], state.tipoDeAleacion) { tipoDeAleacion ->
                    viewModel.seleccionarTipoDeAleacion(tipoDeAleacion)
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 4.dp)
                .clickable { },
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
            elevation = CardDefaults.cardElevation(8.dp),
        ) {
            Column(
                modifier = Modifier.padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Gramos de Oro que deseas usar")
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = state.gramosDeOroPuro,
                    onValueChange = { if (it.matches(Regex("^\\d*(\\.\\d{0,2})?$"))) {
                        viewModel.seleccionarGramosDeOroPuro(it)
                    } },
                    label = { Text("Oro Puro - 24 quilates") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,

                )
            }
        }
    }
}




