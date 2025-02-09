package com.jrblanco.calculadoradejoyeros2021.Home.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun NavigationBarHome(
    selectedIndex: Int,
    onClick: (Int) -> Unit
) {

    val items = listOf(
        NavigationItemData(
            icon = painterResource(id = R.drawable.lingotesdeoro),
            contentDescription = "Oro",
            label = "Oro",
            isSelect = selectedIndex == 0
        ),
        NavigationItemData(
            icon = painterResource(id = R.drawable.lingotesdeplata),
            contentDescription = "Plata",
            label = "Plata",
            isSelect = selectedIndex == 1
        ),
        NavigationItemData(
            icon = painterResource(id = R.drawable.homejoyeria),
            contentDescription = "Principal",
            label = "Principal",
            isSelect = selectedIndex == 2
        ),
        NavigationItemData(
            icon = painterResource(id = R.drawable.soplete),
            contentDescription = "Soldadura",
            label = "Soldadura",
            isSelect = selectedIndex == 3
        ),
        NavigationItemData(
            icon = painterResource(id = R.drawable.utiles),
            contentDescription = "Útiles",
            label = "Útiles",
            isSelect = selectedIndex == 4
        )
    )

    NavigationBar(
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            .border(
                1.dp,
                MaterialTheme.colorScheme.surfaceContainerHighest,
                RoundedCornerShape(16.dp)
            ),
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
                    onClick(index)
                }
            )
        }
    }
}