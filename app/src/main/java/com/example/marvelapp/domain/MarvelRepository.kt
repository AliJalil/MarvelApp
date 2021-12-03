package com.example.marvelapp.domain


import com.example.marvelapp.data.remote.response.BaseResponse
import com.example.marvelapp.domain.models.Character
import com.example.marvelapp.util.Resources
import kotlinx.coroutines.flow.Flow

interface MarvelRepository {

     fun getCharacters() : Flow<Resources<List<Character>?>>
     suspend fun  searchCharacters(characterName: String) : List<Character>

//     fun searchCharactersX(characterName: String) : Flow<Resources<List<Character>?>>

     suspend fun  saveSearchCharacters(characterName: String): List<Character>

//    suspend fun refreshCharacters()
}