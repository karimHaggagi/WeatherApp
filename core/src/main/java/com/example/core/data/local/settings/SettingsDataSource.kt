package com.example.core.data.local.settings

import kotlinx.coroutines.flow.Flow

/**
 * created by Karim Haggagi Hassan Elsayed on 2/11/25
 **/
interface SettingsDataSource {
    suspend fun changeTheme(isDark: Boolean)
    fun getTheme(): Flow<Boolean>

}