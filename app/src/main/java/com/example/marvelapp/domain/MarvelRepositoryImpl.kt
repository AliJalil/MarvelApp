package com.example.marvelapp.domain

import android.util.Log
import com.example.marvelapp.data.remote.network.MarvelApiServices
import com.example.marvelapp.util.Resources
import com.example.marvelapp.util.Resources.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.example.marvelapp.domain.models.Character
import com.example.marvelapp.domain.models.CharacterMapper
import retrofit2.Response
import javax.inject.Inject
import com.example.marvelapp.data.local.MarvelDatabase


class MarvelRepositoryImpl @Inject constructor(
    private val apiService: MarvelApiServices,
    private val characterMapper: CharacterMapper
) : MarvelRepository {


//


    private fun <T> wrapWithFlow(endPointResponse: suspend () -> Response<T>): Flow<Resources<T?>> {
        return flow {
            emit(Loading)
            try {
                val result = endPointResponse()
                if (result.isSuccessful) {
                    emit(Success(result.body()))
                } else {
                    emit(Error(throwable = Throwable(result.message())))
                }
            } catch (throwable: Throwable) {
                Error(throwable)
            }
        }
    }

//    private val characterMapper = CharacterMapper()
//    override fun getCharacters(): Flow<Resources<List<Character>?>> {
//        return wrapWithFlow {
//
//            apiService.getCharacters().body().map {
//                    characterDto -> characterMapper.map(characterDto)
//            }
//    }


    //    private val characterMapper = CharacterMapper()
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
            saveSearchCharacters(characterName)!!
        } else {
            dbResult
        }
    }

    private val characterDao = MarvelDatabase.getInstanceWithoutContext().marvelCharacterDao()
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


//override fun searchCharactersX(characterName: String): Flow<Resources<List<Character>?>> {
//    return flow {
//        emit(Loading)
//        try {
//            val characters = apiService.searchCharacters(characterName)
//                .body()?.items?.results?.map { characterDto ->
//                    characterMapper.mapRemoteToEntity(characterDto)
//                }
//            characters?.let { characterDao.addCharacters(it) }
////                emit(Success(characters))
//
//        } catch (throwable: Throwable) {
//            emit(Error(throwable))
//            Log.v("ALI", throwable.message.toString())
//        }
//    }
//}

//    override fun getCharacter() = characterDao.getCharacters()


//    override suspend fun refreshCharacters() {
//        try {
//            val response = apiService.getCharecters()
//            val items = response.body()?.data?.items?.map {
//                it.apply {
//                    CharacterEntity(
//                        id = id?.toLong() ?: 0L,
//                        name = name ?: "",
//                        description = description ?: "",
//                        modified = modified ?: "",
//                        imageUrl = "${thumbnail!!.path}.${thumbnail!!.extension}"
//                    )
//                }
//            }
//            items?.let { characterDao.addCharacters(it) }
//
//        } catch (e: java.lang.Exception) {
//
//        }
//    }
