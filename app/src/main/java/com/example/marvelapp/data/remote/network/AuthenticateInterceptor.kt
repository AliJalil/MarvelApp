package com.example.marvelapp.data.remote.network

import android.util.Log
import com.example.marvelapp.extension.md5
import com.example.marvelapp.util.Constant
import okhttp3.Interceptor
import okhttp3.Response

class AuthenticateInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val timestamp = System.currentTimeMillis().toString()
        val apiKey = Constant.API_KEY
        val hash = "$timestamp${Constant.PRIVATE_KEY}$apiKey".md5()

        with(chain.request()){
            url.newBuilder().apply {
                addQueryParameter(TIMESTAMP_PARAM,timestamp)
                addQueryParameter(API_KEY_PARAM,apiKey)
                addQueryParameter(HASH_PARAM,hash)
            }.build().also {
                Log.v("ALI", it.toString())
                Log.v("ALI", this.newBuilder().url(it).build().toString())
                return chain.proceed(this.newBuilder().url(it).build())
            }
        }
    }

    companion object
    {
        private const val API_KEY_PARAM = "apikey"
        private const val TIMESTAMP_PARAM = "ts"
        private const val HASH_PARAM = "hash"

    }
}