package com.example.marvelapp.domain

import android.util.Log
import com.example.marvelapp.data.remote.network.MarvelApiServices
import com.example.marvelapp.util.Resources
import com.example.marvelapp.util.Resources.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.example.marvelapp.domain.models.Character
import com.example.marvelapp.domain.models.CharacterMapper
import javax.inject.Inject
import com.example.marvelapp.data.local.MarvelDatabase


class MarvelRepositoryImpl @Inject constructor(
    private val apiService: MarvelApiServices,
    private val characterMapper: CharacterMapper,
    marvelDatabase: MarvelDatabase
) : MarvelRepository {

    private val characterDao = marvelDatabase.marvelCharacterDao()
    override fun getCharacters(): Flow<Resources<List<Character>?>> {
        return flow {
            emit(Loading)
            try {
                val characters =
                    apiService.getCharacters().body()?.items?.results?.map { characterDto ->
                        characterMapper.mapRemoteToDomain(characterDto)
                    }
                emit(Success(characters))
            } catch (throwable: Throwable) {
                emit(Error(throwable))
                Log.v("ALI", throwable.message.toString())
            }
        }
    }

    override suspend fun searchCharacters(characterName: String): List<Character> {
        val dbResult = characterDao.searchCharacters("%${characterName}%")
            .map { characterMapper.mapEntityToDomain(it) }
        return if (dbResult.isEmpty()) {
            saveSearchCharacters(characterName)
        } else {
            dbResult
        }
    }

    override suspend fun saveSearchCharacters(characterName: String): List<Character> {
        val characters = apiService.searchCharacters(characterName)
            .body()?.items?.results?.map { characterDto ->
                characterMapper.mapRemoteToEntity(characterDto)
            }
        characters?.let { characterDao.addCharacters(it) }

        return characters?.let {
            it.map { characterEntity ->
                characterMapper.mapEntityToDomain(characterEntity)
            }
        }.orEmpty()
    }
}

