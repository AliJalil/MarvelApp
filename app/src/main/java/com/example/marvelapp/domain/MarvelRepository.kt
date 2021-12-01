package com.example.marvelapp.domain


import com.example.marvelapp.data.remote.response.BaseResponse
import com.example.marvelapp.domain.models.Character
import com.example.marvelapp.util.Resources
import kotlinx.coroutines.flow.Flow

interface MarvelRepository {

     fun getCharacters() : Flow<Resources<BaseResponse<Character>?>>
//    suspend fun refreshCharacters()
}