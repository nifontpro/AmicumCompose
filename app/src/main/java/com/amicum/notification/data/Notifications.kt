package com.amicum.notification.data

import androidx.annotation.DrawableRes

data class Notifications(
    val title: String = "",
    @DrawableRes val image: Int,
    val tasks: List<String> = emptyList(),
)
