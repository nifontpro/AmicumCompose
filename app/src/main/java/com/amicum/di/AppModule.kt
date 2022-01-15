package com.amicum.di

import com.amicum.notification.repository.NotificationsRepository
import com.amicum.notification.uses_cases.GetNotifications
import com.amicum.notification.uses_cases.NotificationsUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNotifications(): NotificationsRepository = NotificationsRepository()

    @Provides
    @Singleton
    fun provideNotificationsUseCase(repository: NotificationsRepository) = NotificationsUseCases(
        getNotifications = GetNotifications(repository)
    )
}