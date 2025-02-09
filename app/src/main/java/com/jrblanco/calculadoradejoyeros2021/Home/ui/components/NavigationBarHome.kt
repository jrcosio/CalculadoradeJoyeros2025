package com.jrblanco.calculadoradejoyeros2021.Home.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.jrblanco.calculadoradejoyeros2021.R

data class NavigationItemData(
    val icon: Painter,
    val contentDescription: String,
    val label: String,
    val isSelect: Boolean
)

@Composable
fun NavigationBarHome(onClick: (Int) -> Unit) {
    var selecionado by rememberSaveable { mutableIntStateOf(2) }

    val items = listOf(
        NavigationItemData(
            icon = painterResource(id = R.drawable.lingotesdeoro),
            contentDescription = "Oro",
            label = "Oro",
            isSelect = selecionado == 0
        ),
        NavigationItemData(
            icon = painterResource(id = R.drawable.lingotesdeplata),
            contentDescription = "Plata",
            label = "Plata",
            isSelect = selecionado == 1
        ),
        NavigationItemData(
            icon = painterResource(id = R.drawable.homejoyeria),
            contentDescription = "Principal",
            label = "Principal",
            isSelect = selecionado == 2
        ),
        NavigationItemData(
            icon = painterResource(id = R.drawable.soplete),
            contentDescription = "Soldadura",
            label = "Soldadura",
            isSelect = selecionado == 3
        ),
        NavigationItemData(
            icon = painterResource(id = R.drawable.utiles),
            contentDescription = "Útiles",
            label = "Útiles",
            isSelect = selecionado == 4
        )
    )

    NavigationBar(
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
        //.border(1.dp, LisColorAzulClaro40, RoundedCornerShape(16.dp)),
        //contentColor = Color.White,
        //containerColor = Color.Transparent,
        windowInsets = NavigationBarDefaults.windowInsets
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = item.icon,
                        contentDescription = item.contentDescription,
                        modifier = Modifier.size(24.dp)
                    )
                },
                label = { Text(text = item.label) },
                selected = item.isSelect,//selecionado == index,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Unspecified,  // Color del icono seleccionado
                    unselectedIconColor = Color.Unspecified,
                    selectedTextColor = Color.Unspecified,
                    unselectedTextColor = Color.Unspecified,
                    indicatorColor = Color.Unspecified,
                ),
                onClick = {
                    selecionado = index
                    onClick(index)
                }
            )
        }
    }
}