package com.example.settings.data

import com.example.core.data.local.settings.SettingsDataSource
import com.example.settings.domain.SettingsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * created by Karim Haggagi Hassan Elsayed on 2/11/25
 **/
class SettingsRepoImp @Inject constructor(private val settingsDataSource: SettingsDataSource):SettingsRepository {
    override suspend fun changeTheme(isDark: Boolean) {
        settingsDataSource.changeTheme(isDark)
    }

    override fun getTheme(): Flow<Boolean> {
       return settingsDataSource.getTheme()
    }
}