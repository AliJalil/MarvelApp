package com.example.marvelapp.domain

import com.example.marvelapp.domain.models.Character
import com.example.marvelapp.util.Resources
import kotlinx.coroutines.flow.Flow

interface MarvelRepository {

    fun getCharacter(): Flow<Resources<List<Character>?>>
    suspend fun refreshCharacters()
}