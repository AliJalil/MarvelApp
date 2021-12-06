package com.example.marvelapp.di

import com.example.marvelapp.data.remote.network.AuthenticateInterceptor
import com.example.marvelapp.data.remote.network.MarvelApiServices
import com.example.marvelapp.util.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideMarvelService(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): MarvelApiServices {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()

        return retrofit.create(MarvelApiServices::class.java)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        authenticateInterceptor: AuthenticateInterceptor,
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient
            .Builder()
            .addInterceptor(
                loggingInterceptor
            )
            .addInterceptor(authenticateInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideAuthenticateInterceptor(): AuthenticateInterceptor = AuthenticateInterceptor()

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor()
        .apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }

    @Singleton
    @Provides
    fun provideGSON(): GsonConverterFactory = GsonConverterFactory.create()
}
