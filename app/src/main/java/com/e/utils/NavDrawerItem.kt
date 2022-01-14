package com.e.utils

import com.e.R

sealed class NavDrawerItem(var route: String, var icon: Int, var title: String) {
    object Home : NavDrawerItem("home", R.drawable.icon_home, "На главную")
    object Report : NavDrawerItem("report", R.drawable.icon_report, "Заполнить отчет")
    object Materials : NavDrawerItem("materials", R.drawable.icon_materials, "Учет материалов")
    object Time : NavDrawerItem("time", R.drawable.icon_time, "Учет простоев")

    object Notification :
        NavDrawerItem("notification", R.drawable.icon_with_notification, "Уведомления")
    object Settings : NavDrawerItem("settings", R.drawable.icon_setting, "Настройки")
}