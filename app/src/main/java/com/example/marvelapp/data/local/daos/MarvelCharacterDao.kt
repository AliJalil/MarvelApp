package com.example.marvelapp.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.marvelapp.data.local.entity.CharacterEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MarvelCharacterDao {
//
    @Insert
    suspend fun addCharacters(items: List<CharacterEntity>)

    @Query("Select * from CharacterEntity")
    fun getCharacters(): Flow<List<CharacterEntity>>
}