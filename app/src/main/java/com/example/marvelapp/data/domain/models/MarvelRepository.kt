package com.example.marvelapp.data.domain.models

import com.bumptech.glide.load.engine.Resource
import com.example.marvelapp.data.remote.response.BaseResponse
import com.example.marvelapp.data.remote.response.CharecterDto
import com.example.marvelapp.util.State
import kotlinx.coroutines.flow.Flow

interface MarvelRepository {

    fun getCharacter():Flow<State<BaseResponse<CharecterDto>?>>
    suspend fun refreshCharacters()
}