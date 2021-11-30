package com.example.marvelapp.domain

import com.example.marvelapp.domain.models.CharacterMapper
import com.example.marvelapp.data.local.MarvelDatabase
import com.example.marvelapp.data.local.entity.CharacterEntity
import com.example.marvelapp.data.remote.network.API
import com.example.marvelapp.util.Resources
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.example.marvelapp.domain.models.Character

class MarvelRepositoryImpl : MarvelRepository {

    private val apiService = API.apiService
    private val characterDao = MarvelDatabase.getInstanceWithoutContext().marvelDao()

//    fun <T> wrapWithFlow(endPointResponse: suspend () -> Response<T>): Flow<State<T?>> {
//        return flow {
//            emit(State.Loading)
//            try {
//                val result = endPointResponse()
//                if (result.isSuccessful) {
//                    emit(State.Success(result.body()))
//                } else {
//                    emit(State.Error(result.message()))
//                }
//            } catch (e: Exception) {
//                State.Error(e.message.toString())
//            }
//        }
//    }

    private val characterMapper = CharacterMapper()
    override fun getCharacter(): Flow<Resources<List<Character>?>> {
        return flow {
            emit(Resources.Loading)
            try {
                val characters =
                    apiService.getCharecters().body()?.data?.items?.map { characterDto ->
                        characterMapper.map(characterDto)
                    }
                emit(Resources.Success(characters))
            } catch (throwable: Throwable) {
                emit(Resources.Error(throwable))
            }
        }
    }


//    override fun getCharacter() = characterDao.getCharacters()


    override suspend fun refreshCharacters() {
        try {
            val response = apiService.getCharecters()
            val items = response.body()?.data?.items?.map {
                it.apply {
                    CharacterEntity(
                        id = id?.toLong() ?: 0L,
                        name = name ?: "",
                        description = description ?: "",
                        modified = modified ?: "",
                        imageUrl = "${thumbnail.path}.${thumbnail.extension}"
                    )
                }
            }
            items?.let { characterDao.addCharacters(it) }

        } catch (e: java.lang.Exception) {

        }
    }
}