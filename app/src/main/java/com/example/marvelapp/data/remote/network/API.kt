package com.example.marvelapp.data.remote.network

import com.example.marvelapp.util.Constant
import com.example.marvelapp.util.Constant.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//object API {
//    private val logging = HttpLoggingInterceptor()
//        .apply {
//            level = HttpLoggingInterceptor.Level.BODY
//        }
//
//    private val okHttpClient = OkHttpClient
//        .Builder()
//        .addInterceptor(logging)
//        .build()
//
//    private val retrofit = Retrofit.Builder()
//        .baseUrl(BASE_URL)
//        .addConverterFactory(GsonConverterFactory.create())
//        .client(okHttpClient)
//        .build()
//
//    val apiService: MarvelApiServices = retrofit.create(MarvelApiServices::class.java)
//}