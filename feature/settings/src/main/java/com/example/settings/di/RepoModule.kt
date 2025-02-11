package com.example.settings.di

import com.example.settings.data.SettingsRepoImp
import com.example.settings.domain.SettingsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * created by Karim Haggagi Hassan Elsayed on 2/11/25
 **/
@Module
@InstallIn(SingletonComponent::class)
interface RepoModule {
    @Binds
    fun provideSettingsRepository(settingsRepoImp: SettingsRepoImp): SettingsRepository
}