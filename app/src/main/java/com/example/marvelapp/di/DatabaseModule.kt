package com.example.marvelapp.di

import android.content.Context
import androidx.room.Room
import com.example.marvelapp.data.local.MarvelDatabase
import com.example.marvelapp.data.local.daos.MarvelCharacterDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideMarvelDatabase(@ApplicationContext context: Context): MarvelDatabase {
        return Room.databaseBuilder(
            context,
            MarvelDatabase::class.java,
            MarvelDatabase.DATABASE_NAME
        ).allowMainThreadQueries().build()
    }

    @Singleton
    @Provides
    fun provideCharacterDao(marvelDatabase: MarvelDatabase):MarvelCharacterDao
    {
        return marvelDatabase.marvelCharacterDao()
    }
}