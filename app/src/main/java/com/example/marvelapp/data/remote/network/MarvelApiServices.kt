package com.example.marvelapp.data.remote.network

import com.example.marvelapp.data.remote.response.BaseResponse
import com.example.marvelapp.data.remote.response.CharacterDto
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import com.example.marvelapp.domain.models.Character
import com.example.marvelapp.util.Constant

interface MarvelApiServices {

//    fun getCharecters(): Response<BaseResponse<CharacterDto>>

    @GET("characters")
    suspend fun getCharacters() : Response<BaseResponse<CharacterDto>>
}
