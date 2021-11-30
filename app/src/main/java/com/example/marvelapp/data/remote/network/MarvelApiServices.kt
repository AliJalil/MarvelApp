package com.example.marvelapp.data.remote.network

import com.example.marvelapp.data.remote.response.BaseResponse
import com.example.marvelapp.data.remote.response.CharacterDto
import retrofit2.Response


interface MarvelApiServices {

    fun getCharecters(): Response<BaseResponse<CharacterDto>>
}