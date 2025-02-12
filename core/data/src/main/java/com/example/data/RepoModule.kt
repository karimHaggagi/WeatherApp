package com.example.data

import com.example.data.home.HomeRepoImp
import com.example.data.home.HomeRepository
import com.example.data.search.SearchRepo
import com.example.data.search.SearchRepoImpl
import com.example.data.settings.SettingsRepoImp
import com.example.data.settings.SettingsRepository
import com.example.data_base.LocalDataSource
import com.example.data_base.room.RoomLocalDataSource
import com.example.data_store.SettingsDataSource
import com.example.data_store.SettingsDataStore
import com.example.network.RemoteDataSource
import com.example.network.retrofit.RetrofitRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * created by Karim Haggagi Hassan Elsayed on 2/4/25
 **/
@Module
@InstallIn(SingletonComponent::class)
internal interface RepoModule {

    @Binds
    fun provideHomeRepository(repo: HomeRepoImp): HomeRepository
    @Binds
    fun provideSearchRepository(repo: SearchRepoImpl): SearchRepo
    @Binds
    fun provideSettingsRepository(settingsRepoImp: SettingsRepoImp): SettingsRepository


    @Binds
    fun provideRemoteDataSource(dataSource: RetrofitRemoteDataSource): RemoteDataSource
    @Binds
    fun provideLocalDataSource(dataSource: RoomLocalDataSource): LocalDataSource
    @Binds
    fun provideSettingsDataSource(dataSource:SettingsDataStore): SettingsDataSource


}