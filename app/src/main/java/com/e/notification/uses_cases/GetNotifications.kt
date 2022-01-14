package com.e.notification.uses_cases

import com.e.notification.repository.NotificationsRepository

class GetNotifications(
    private val repository: NotificationsRepository
) {
    operator fun invoke() = repository.notifications
}