package com.jrblanco.calculadoradejoyeros2021.Principal

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jrblanco.calculadoradejoyeros2021.R

@Composable
fun PrincipalScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        SeccionPrincipal(
            imageResId = R.drawable.lingotesdeorocolor,
            title = stringResource(R.string.SeccionOro),
            subtitle = stringResource(R.string.TextoSeccionOro),
        )
        SeccionPrincipal(
            imageResId = R.drawable.lingotesdeplatacolor,
            title = stringResource(R.string.SeccionPlata),
            subtitle = stringResource(R.string.TextoSeccionPlata),
        )
        SeccionPrincipal(
            imageResId = R.drawable.sopletecolor,
            title = stringResource(R.string.SeccionSoldadura),
            subtitle = stringResource(R.string.TextoSeccionSoldadura),
        )
        SeccionPrincipal(
            imageResId = R.drawable.utilescolor,
            title = stringResource(R.string.SeccionUtiles),
            subtitle = stringResource(R.string.TextoSeccionUtiles),
        )

    }
}

@Composable

fun SeccionPrincipal(imageResId: Int, title: String, subtitle: String) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        elevation = CardDefaults.cardElevation(8.dp),
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier
                    .size(130.dp)
                    .padding(8.dp)
                    .border(1.dp, MaterialTheme.colorScheme.onPrimaryContainer, RoundedCornerShape(8.dp))
                    .clip(RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(imageResId),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = title,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Text(
                    text = subtitle,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    fontSize = 14.sp
                )
            }
        }
    }
}
