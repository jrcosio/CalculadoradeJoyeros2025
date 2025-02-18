package com.jrblanco.calculadoradejoyeros2021.Oro.ui.data

import com.jrblanco.calculadoradejoyeros2021.R

data class AleacionOro(
    val title: String,
    val logo: Int,
    val subtitle: String
)

data class TipoDeOro(
    val title: String,
    val logo: Int
)

val AleacionesDeOro = listOf(
    AleacionOro(
        title = "18K",
        logo = R.drawable.ic_launcher_background,
        subtitle = "18 quilates"
    ),
    AleacionOro(
        title = "14K",
        logo = R.drawable.ic_launcher_background,
        subtitle = "14 quilates"
    ),
    AleacionOro(
        title = "12K",
        logo = R.drawable.ic_launcher_background,
        subtitle = "12 quilates"
    ),
    AleacionOro(
        title = "10K",
        logo = R.drawable.ic_launcher_background,
        subtitle = "10 quilates"
    ),
    AleacionOro(
        title = "9K",
        logo = R.drawable.ic_launcher_background,
        subtitle = "9 quilates"
    )
)

val TiposDeOro = listOf(
    TipoDeOro(
        title = "Oro Amarillo",
        logo = R.drawable.ic_launcher_background,
    ),
    TipoDeOro(
        title = "Oro Blanco",
        logo = R.drawable.ic_launcher_background
    ),
    TipoDeOro(
        title = "Oro Rosa",
        logo = R.drawable.ic_launcher_background
    )
)