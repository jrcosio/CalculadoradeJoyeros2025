package com.jrblanco.calculadoradejoyeros2021.Home.ui.components

import androidx.compose.foundation.border
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
    val label: String
)

@Composable
fun NavigationBarHome(onClick: (Int) -> Unit) {
    //var selecionado by rememberSaveable { mutableIntStateOf(selectInicio) }

    val items = listOf(
        NavigationItemData(
            icon = painterResource(id = R.drawable.icons_home),
            contentDescription = "Oro",
            label = "Oro"
        ),
        NavigationItemData(
            icon = painterResource(id = R.drawable.icons_home),
            contentDescription = "Plata",
            label = "Plata"
        ),
        NavigationItemData(
            icon = painterResource(id = R.drawable.icons_home),
            contentDescription = "Soldaduras",
            label = "Soldaduras"
        ),
        NavigationItemData(
            icon = painterResource(id = R.drawable.icons_home),
            contentDescription = "Fundición",
            label = "Fundición"
        ),
        NavigationItemData(
            icon = painterResource(id = R.drawable.icons_home),
            contentDescription = "Utilidades de joyería",
            label = "Utiles"
        )

    )

    NavigationBar(
        modifier = Modifier,
        //.clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
        //.border(1.dp, LisColorAzulClaro40, RoundedCornerShape(16.dp)),
        contentColor = Color.White,
        containerColor = Color.Transparent,
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
                selected = false,//selecionado == index,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,  // Color del icono seleccionado
                    //unselectedIconColor = LisColorAzulClaro,
                    //selectedTextColor = LisColorAzulClaro40,
                    //unselectedTextColor = LisColorAzulClaro,
                    //indicatorColor = LisColorAzulClaro40,
                ),
                onClick = { }
            )
        }
    }
}