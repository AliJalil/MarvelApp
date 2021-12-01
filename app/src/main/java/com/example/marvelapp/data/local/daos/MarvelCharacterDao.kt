package com.example.marvelapp.data.local.daos

import androidx.room.*
import com.example.marvelapp.data.local.entity.CharacterEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MarvelCharacterDao {
//
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCharacters(items: List<CharacterEntity>)

    @Query("Select * from CharacterEntity")
    fun getCharacters(): Flow<List<CharacterEntity>>
}