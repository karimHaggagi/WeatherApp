package com.example.home.di

import com.example.home.data.datasource.remote.RemoteDataSource
import com.example.home.data.datasource.remote.RetrofitRemoteDataSource
import com.example.home.data.repoImpl.HomeRepoImp
import com.example.home.domain.repository.HomeRepository
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
    fun provideRepository(repo: HomeRepoImp): HomeRepository

    @Binds
    fun provideRemoteDataSource(dataSource: RetrofitRemoteDataSource): RemoteDataSource

}