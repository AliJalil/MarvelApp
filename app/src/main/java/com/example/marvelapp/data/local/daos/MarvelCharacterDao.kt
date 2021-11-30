package com.example.marvelapp.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.OnConflictStrategy
import com.example.marvelapp.data.local.entity.CharacterEntity
import com.example.marvelapp.data.remote.response.CharacterDto
import kotlinx.coroutines.flow.Flow

@Dao
interface MarvelCharacterDao {
//
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCharacters(items: List<CharacterDto>)

    @Query("Select * from CharacterEntity")
    fun getCharacters(): Flow<List<CharacterEntity>>
}