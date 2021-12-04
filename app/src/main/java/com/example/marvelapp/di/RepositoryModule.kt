package com.example.marvelapp.di

import com.example.marvelapp.data.local.MarvelDatabase
import com.example.marvelapp.data.local.daos.MarvelCharacterDao
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
    fun provideRepository(
        apiServices: MarvelApiServices,
        characterMapper: CharacterMapper,
        marvelDatabase: MarvelDatabase
    ): MarvelRepository =
        MarvelRepositoryImpl(
            apiService = apiServices,
            characterMapper = characterMapper,
            marvelDatabase = marvelDatabase
        )


    @Provides
    fun provideCharacterMapper(): CharacterMapper = CharacterMapper()

//    @Provides
//    fun provideMarvelDatabase(): MarvelDatabase = MarvelDatabase.getInstanceWithoutContext()
//

}