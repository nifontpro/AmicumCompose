package com.amicum.notification.uses_cases

import com.amicum.notification.repository.NotificationsRepository

class GetNotifications(
    private val repository: NotificationsRepository
) {
    operator fun invoke() = repository.notifications
}