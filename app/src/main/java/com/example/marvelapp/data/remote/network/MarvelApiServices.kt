package com.example.marvelapp.data.remote.network

import com.example.marvelapp.data.remote.response.BaseResponse
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
    suspend fun getCharacters() : Response<BaseResponse<Character>>



}




//
//interface MarvelApiService {
//    @GET("v1/public/characters")
//    suspend fun getCharacters() : Response<BaseMarvel<CharacterData>>
//}
//
//object Api {
//
//    val retrofit = Retrofit.Builder()
//        .baseUrl(Constant.BASE_URL)
//        .client(Client.apiClient.build())
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//
//    val marvelApi = retrofit.create(MarvelApiService::class.java)
//}
//
//object Client {
//    val apiClient = OkHttpClient.Builder()
//        .addInterceptor(Interceptor { chain ->
//            val origin = chain.request()
//            val originHttpUrl = origin.url
//                .newBuilder()
//                .addQueryParameter("ts", Constant.TS)
//                .addQueryParameter("apikey",Constant.API_KEY)
//                .addQueryParameter("hash",Constant.MY_HASH)
//                .build()
//            val request = origin.newBuilder().url(originHttpUrl).build()
//            chain.proceed(request)
//        })
//}