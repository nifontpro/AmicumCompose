package com.amicum.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun TopBar(header: String, onBack: () -> Unit) {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colors.primaryVariant)
            .fillMaxWidth()
            .padding(start = 10.dp, top = 5.dp, bottom = 5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = onBack,
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack, contentDescription = "Back",
                tint = MaterialTheme.colors.onBackground
            )
        }

        Text(
            text = header,
            style = MaterialTheme.typography.h5
        )
    }
}

@Composable
fun TopBarOther(
    header: String,
    image: ImageVector = Icons.Default.ArrowBack,
    imageOther: ImageVector,
    onBack: () -> Unit,
    onOther: () -> Unit
) {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colors.primaryVariant)
            .fillMaxWidth()
            .padding(start = 10.dp, top = 5.dp, bottom = 5.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = onBack,
        ) {
            Icon(
                imageVector = image, contentDescription = "Back",
                tint = MaterialTheme.colors.onBackground
            )
        }

        Text(
            text = header,
            style = MaterialTheme.typography.h5
        )

        IconButton(
            onClick = onOther,
        ) {
            Icon(
                imageVector = imageOther, contentDescription = "Other",
                tint = MaterialTheme.colors.onBackground
            )
        }
    }
}
