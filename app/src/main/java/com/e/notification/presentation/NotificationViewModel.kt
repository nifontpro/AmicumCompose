package com.e.notification.presentation

import androidx.lifecycle.ViewModel
import com.e.notification.uses_cases.NotificationsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotificationViewModel @Inject constructor(
    notificationsUseCases: NotificationsUseCases
) : ViewModel() {
    val notifications = notificationsUseCases.getNotifications()
}