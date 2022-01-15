package com.amicum.notification.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.amicum.notification.data.Notifications
import com.amicum.ui.theme.DarkRed

@Composable
fun NotificationScreen() {

    val viewModel: NotificationViewModel = hiltViewModel()
    val notifications = viewModel.notifications.collectAsState().value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            item {
                Text(
                    "События",
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.padding(10.dp)
                )
            }
            items(notifications) { item ->
                NotificationCard(item)
            }
        }
    }
}

@Composable
private fun NotificationCard(item: Notifications) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp, horizontal = 10.dp),
        elevation = 10.dp
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
//                        horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painterResource(id = item.image),
                    contentDescription = null,
                    Modifier
                        .size(30.dp)
                        .padding(end = 10.dp)
                )
                Text(item.title, style = MaterialTheme.typography.h6, color = DarkRed)
            }
            Column {
                item.tasks.forEachIndexed { idx, task ->
                    Text(
                        task,
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier.padding(vertical = 10.dp)
                    )
                    if (idx < item.tasks.lastIndex) {
                        Divider()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    NotificationScreen()
}