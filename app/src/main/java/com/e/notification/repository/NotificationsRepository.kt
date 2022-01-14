package com.e.notification.repository

import com.e.R
import com.e.notification.data.Notifications
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class NotificationsRepository {

    private val _notifications: MutableStateFlow<List<Notifications>> =
        MutableStateFlow(emptyList())
    val notifications = _notifications.asStateFlow()

    init {
        _notifications.value = listOf(
            Notifications(
                "Необходимая замена СИЗ",
                R.drawable.notification_siz,
                listOf("Тапки", "Сапоги")
            ),
            Notifications(
                "Запланированный медицинский осмотр",
                R.drawable.notification_medical,
                listOf("Пупкин Иван Иванович", "Иванов Иван Иванович")
            ),
            Notifications(
                "Выдан ПАБ",
                R.drawable.notification_pab,
                listOf("Пупкин Иван Иванович")
            ),
            Notifications(
                "Запланирован аудит",
                R.drawable.notification_audit,
                listOf("Конвейерный штрек 565", "Пласта семирного")
            ),
            Notifications(
                "Запланирована проверка знаний",
                R.drawable.notification_check_knowledge,
                listOf("Пупкин Иван Иванович")
            ),
            Notifications(
                "Необходимо пройти инструктаж",
                R.drawable.notification_injunction,
                listOf("Тапки", "Сапоги")
            ),
            Notifications(
                "Необходимая замена СИЗ",
                R.drawable.notification_siz,
                listOf("Тапки", "Сапоги")
            ),
            Notifications(
                "Запланированный медицинский осмотр",
                R.drawable.notification_medical,
                listOf("Пупкин Иван Иванович", "Иванов Иван Иванович")
            ),
            Notifications(
                "Выдан ПАБ",
                R.drawable.notification_pab,
                listOf("Пупкин Иван Иванович")
            ),
            Notifications(
                "Запланирован аудит",
                R.drawable.notification_audit,
                listOf("Конвейерный штрек 565", "Пласта семирного")
            ),
            Notifications(
                "Запланирована проверка знаний",
                R.drawable.notification_check_knowledge,
                listOf("Пупкин Иван Иванович")
            ),
            Notifications(
                "Необходимо пройти инструктаж",
                R.drawable.notification_injunction,
                listOf("Тапки", "Сапоги")
            ),
        )
    }
}