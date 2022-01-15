package com.amicum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.amicum.home.presentation.HomeScreen
import com.amicum.materials.presentation.MaterialsScreen
import com.amicum.notification.presentation.NotificationScreen
import com.amicum.report.presentation.ReportScreen
import com.amicum.ui.theme.AmicumComposeTheme
import com.amicum.utils.NavDrawerItem
import dagger.hilt.android.AndroidEntryPoint

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

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = NavDrawerItem.Home.route) {
        composable(NavDrawerItem.Home.route) {
            HomeScreen(navController)
        }
        composable(NavDrawerItem.Report.route) {
            ReportScreen()
        }
        composable(NavDrawerItem.Materials.route) {
            MaterialsScreen()
        }
        composable(NavDrawerItem.Time.route) {
        }
        composable(NavDrawerItem.Notification.route) {
            NotificationScreen()
        }
        composable(NavDrawerItem.Settings.route) {
        }
    }
}