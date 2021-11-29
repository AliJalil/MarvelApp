package com.example.marvelapp.data.remote.network

import com.example.marvelapp.data.remote.response.BaseResponse
import com.example.marvelapp.data.remote.response.CharecterDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface MarvelApiServices {

    fun getCharecters(): Response<BaseResponse<CharecterDto>>
}