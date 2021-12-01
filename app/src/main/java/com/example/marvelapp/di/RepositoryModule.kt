package com.example.marvelapp.di

import com.example.marvelapp.data.remote.network.MarvelApiServices
import com.example.marvelapp.domain.MarvelRepository
import com.example.marvelapp.domain.MarvelRepositoryImpl
import com.example.marvelapp.domain.models.CharacterMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRepository(apiServices: MarvelApiServices): MarvelRepository =
        MarvelRepositoryImpl(apiService = apiServices)


//    @Provides
//    fun provideCharacterMapper() : CharacterMapper = CharacterMapper()
//
}