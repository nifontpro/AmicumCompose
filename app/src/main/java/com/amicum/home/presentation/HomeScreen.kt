package com.amicum.home.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.amicum.R
import com.amicum.utils.*
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(navController: NavHostController, comment: String?) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = comment) {
        comment?.let {
            scaffoldState.snackbarHostState.showSnackbar(comment)
            navController.currentBackStackEntry?.arguments?.putString(
                Arg.comment, null
            )
        }
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopBarOther(header = stringResource(R.string.app_name),
                image = Icons.Filled.Menu,
                imageOther = Icons.Outlined.Notifications,
                onBack = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }) {
                navController.navigate(NavDrawerItem.Notification.route)
            }
        },
        drawerContent = {
            Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
        },
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
//                .wrapContentSize(Alignment.Center)
        ) {
            Button(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(30.dp),
                onClick = { navController.navigate(Screen.TestWorkScreen.route) }) {
                Text("Тестовое задание", color = MaterialTheme.colors.onBackground)
            }
            Text(
                text = "Домашний экран",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Center),
                textAlign = TextAlign.Center,
                fontSize = 25.sp
            )
        }
    }
}