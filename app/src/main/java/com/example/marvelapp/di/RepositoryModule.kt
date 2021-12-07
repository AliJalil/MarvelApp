package com.example.marvelapp.di

import com.example.marvelapp.data.local.MarvelDatabase
import com.example.marvelapp.data.remote.network.MarvelApiServices
import com.example.marvelapp.domain.MarvelRepository
import com.example.marvelapp.domain.MarvelRepositoryImpl
import com.example.marvelapp.domain.models.CharacterDomainMapper
import com.example.marvelapp.domain.models.CharacterEntityMapper
import com.example.marvelapp.domain.models.CharacterEntityToDomainMapper
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
        characterDomainMapper: CharacterDomainMapper,
        characterEntityMapper: CharacterEntityMapper,
        characterEntityToDomainMapper: CharacterEntityToDomainMapper,
        marvelDatabase: MarvelDatabase
    ): MarvelRepository =
        MarvelRepositoryImpl(
            apiService = apiServices,
            characterDomainMapper = characterDomainMapper,
            characterEntityMapper = characterEntityMapper,
            characterEntityToDomainMapper = characterEntityToDomainMapper,
            marvelDatabase = marvelDatabase
        )


    @Provides
    fun provideCharacterDomainMapper(): CharacterDomainMapper = CharacterDomainMapper()

    @Provides
    fun provideCharacterEntityMapper(): CharacterEntityMapper = CharacterEntityMapper()

    @Provides
    fun provideCharacterEntityToDomainMapper(): CharacterEntityToDomainMapper =
        CharacterEntityToDomainMapper()

}