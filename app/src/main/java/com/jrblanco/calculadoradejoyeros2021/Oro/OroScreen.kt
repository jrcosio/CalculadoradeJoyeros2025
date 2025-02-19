package com.jrblanco.calculadoradejoyeros2021.Oro

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jrblanco.calculadoradejoyeros2021.Oro.ui.OroEstados
import com.jrblanco.calculadoradejoyeros2021.Oro.ui.OroScreenViewModel
import com.jrblanco.calculadoradejoyeros2021.Oro.ui.componentes.CardOro
import com.jrblanco.calculadoradejoyeros2021.Oro.ui.componentes.CardQuilates
import com.jrblanco.calculadoradejoyeros2021.Oro.ui.data.AleacionesDeOro
import com.jrblanco.calculadoradejoyeros2021.Oro.ui.data.TiposDeOro
import com.jrblanco.calculadoradejoyeros2021.R


@Composable
fun OroScreen(
    modifier: Modifier = Modifier,
    viewModel: OroScreenViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top
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
                .padding(horizontal = 8.dp, vertical = 4.dp),
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
                    onValueChange = {
                        if (it.matches(Regex("^\\d*(\\.\\d{0,2})?$"))) {
                            viewModel.seleccionarGramosDeOroPuro(it)
                        }
                    },
                    label = { Text("Oro Puro - 24 quilates") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        if (state.gramosDeOroPuro != "" && state.tipoDeOro != "" && state.tipoDeAleacion != "") {
            CalculoMetales(state)
        }

    }
}

@Composable
fun CalculoMetales(state: OroEstados) {
    val metales = generarOro(state)
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        elevation = CardDefaults.cardElevation(8.dp),
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .weight(1f)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(text = "Necesitas los siguientes matales")
            Spacer(modifier = Modifier.height(8.dp))
            if (metales["plata"] != 0.0f) {
                ItemMaterial(
                    nombre = "Plata",
                    imagen = R.drawable.ic_launcher_background,
                    cantidad = metales["plata"]!!
                )
            }
            if (metales["cobre"] != 0.0f) {
                Spacer(modifier = Modifier.height(8.dp))
                ItemMaterial(
                    nombre = "Cobre",
                    imagen = R.drawable.ic_launcher_background,
                    cantidad = metales["cobre"]!!
                )
            }
            if (metales["paladio"] != 0.0f) {
                Spacer(modifier = Modifier.height(8.dp))
                ItemMaterial(
                    nombre = "Paladio",
                    imagen = R.drawable.ic_launcher_background,
                    cantidad = metales["paladio"]!!
                )
            }

        }
    }
}

@Composable
fun ItemMaterial(nombre: String, imagen: Int, cantidad: Float) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onPrimaryContainer
        ),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = imagen),
                contentDescription = "Imagen de tarjeta",
                modifier = Modifier.size(64.dp),
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = nombre,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimary
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "${cantidad} gr",
                fontSize = 32.sp,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }

    }
}

fun generarOro(state: OroEstados): Map<String, Float> {
    val gramos = state.gramosDeOroPuro.toFloatOrNull() ?: 0f
    var plata = 0.0f
    var cobre = 0.0f
    var paladio = 0.0f

    when (state.tipoDeOro) {
        "Oro Amarillo" -> {
            when (state.tipoDeAleacion) {
                "18K" -> {
                    plata = (gramos * 0.75).toFloat()
                    cobre = (gramos * 0.25).toFloat()
                }

                "14K" -> {
                    plata = (gramos * 0.585).toFloat()
                    cobre = (gramos * 0.415).toFloat()
                }

                "12K" -> {
                    plata = (gramos * 0.5).toFloat()
                    cobre = (gramos * 0.5).toFloat()
                }

                "10K" -> {
                    plata = (gramos * 0.417).toFloat()
                    cobre = (gramos * 0.583).toFloat()
                }

                "9K" -> {
                    plata = (gramos * 0.375).toFloat()
                    cobre = (gramos * 0.625).toFloat()
                }
            }
        }

        "Oro Blanco" -> {
            when (state.tipoDeAleacion) {
                "18K" -> {
                    paladio = (gramos * 0.75).toFloat()
                    plata = (gramos * 0.25).toFloat()
                }

                "14K" -> {
                    paladio = (gramos * 0.585).toFloat()
                    plata = (gramos * 0.415).toFloat()
                }

                "12K" -> {
                    paladio = (gramos * 0.5).toFloat()
                    plata = (gramos * 0.5).toFloat()
                }

                "10K" -> {
                    paladio = (gramos * 0.417).toFloat()
                    plata = (gramos * 0.583).toFloat()
                }

                "9K" -> {
                    paladio = (gramos * 0.375).toFloat()
                    plata = (gramos * 0.625).toFloat()
                }
            }
        }

        "Oro Rosa" -> {
            when (state.tipoDeAleacion) {
                "18K" -> {
                    cobre = (gramos * 0.75).toFloat()
                    plata = (gramos * 0.25).toFloat()
                }

                "14K" -> {
                    cobre = (gramos * 0.585).toFloat()
                    plata = (gramos * 0.415).toFloat()
                }

                "12K" -> {
                    cobre = (gramos * 0.5).toFloat()
                    plata = (gramos * 0.5).toFloat()
                }

                "10K" -> {
                    cobre = (gramos * 0.417).toFloat()
                    plata = (gramos * 0.583).toFloat()
                }

                "9K" -> {
                    cobre = (gramos * 0.375).toFloat()
                    plata = (gramos * 0.625).toFloat()
                }
            }
        }
    }
    return mapOf(
        "plata" to String.format("%.2f", plata).toFloat(),
        "cobre" to String.format("%.2f", cobre).toFloat(),
        "paladio" to String.format("%.2f", paladio).toFloat()
    )
}




