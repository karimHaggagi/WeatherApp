package com.example.search.di

import com.example.search.data.datasource.local.LocalDataSource
import com.example.search.data.datasource.local.RoomLocalDataSource
import com.example.search.data.datasource.remote.RemoteDataSource
import com.example.search.data.datasource.remote.RetrofitRemoteDataSource
import com.example.search.data.repoImpl.SearchRepoImpl
import com.example.search.domain.repo.SearchRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * created by Karim Haggagi Hassan Elsayed on 2/4/25
 **/
@Module
@InstallIn(SingletonComponent::class)
interface RepoModule {

    @Binds
    fun provideRepository(repo: SearchRepoImpl): SearchRepo

    @Binds
    fun provideRemoteDataSource(dataSource: RetrofitRemoteDataSource): RemoteDataSource

    @Binds
    fun provideLocalDataSource(dataSource: RoomLocalDataSource): LocalDataSource

}