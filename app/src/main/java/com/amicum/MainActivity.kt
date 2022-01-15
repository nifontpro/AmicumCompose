package com.amicum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.amicum.home.presentation.HomeScreen
import com.amicum.materials.presentation.MaterialsScreen
import com.amicum.notification.presentation.NotificationScreen
import com.amicum.report.presentation.ReportScreen
import com.amicum.test_work.presentation.TestWorkScreen
import com.amicum.time.presentation.TimeScreen
import com.amicum.ui.theme.AmicumComposeTheme
import com.amicum.utils.Arg
import com.amicum.utils.NavDrawerItem
import com.amicum.utils.Screen
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalComposeUiApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AmicumComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MainScreen()
                }
            }
        }
    }
}

@ExperimentalComposeUiApi
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = NavDrawerItem.Home.route) {

        // Drawer Menu:
        composable(NavDrawerItem.Home.route,
        arguments = listOf(
            navArgument(Arg.comment) {
                type = NavType.StringType
                defaultValue = null
                nullable = true
            }
        )) { entry ->
            val comment = entry.arguments?.getString(Arg.comment)
            HomeScreen(navController, comment)
        }
        composable(NavDrawerItem.Report.route) {
            ReportScreen(navController)
        }
        composable(NavDrawerItem.Materials.route) {
            MaterialsScreen(navController)
        }
        composable(NavDrawerItem.Time.route) {
            TimeScreen(navController)
        }
        composable(NavDrawerItem.Notification.route) {
            NotificationScreen(navController)
        }
        composable(NavDrawerItem.Settings.route) {
        }

        // Other:
        composable(Screen.TestWorkScreen.route) {
            TestWorkScreen(navController)
        }
    }
}