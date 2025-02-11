package com.example.settings.domain

import kotlinx.coroutines.flow.Flow

/**
 * created by Karim Haggagi Hassan Elsayed on 2/11/25
 **/
interface SettingsRepository {
    suspend fun changeTheme(isDark: Boolean)
    fun getTheme(): Flow<Boolean>
}