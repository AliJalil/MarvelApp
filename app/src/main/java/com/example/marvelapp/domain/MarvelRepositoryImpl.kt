package com.example.marvelapp.domain

import android.util.Log
import com.example.marvelapp.data.remote.network.MarvelApiServices
import com.example.marvelapp.data.remote.response.BaseResponse
import com.example.marvelapp.domain.mapper.Mapper
import com.example.marvelapp.util.Resources
import com.example.marvelapp.util.Resources.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.example.marvelapp.domain.models.Character
import com.example.marvelapp.domain.models.CharacterMapper
import retrofit2.Response
import javax.inject.Inject


class MarvelRepositoryImpl @Inject constructor(
    private val apiService: MarvelApiServices,
    private val characterMapper : CharacterMapper
) : MarvelRepository {


//    private val characterDao = MarvelDatabase.getInstanceWithoutContext().marvelDao()


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
                val characters = apiService.getCharacters().body()?.items?.results?.map { characterDto ->
                    characterMapper.map(characterDto)
                }
                emit(Success(characters))

            } catch (throwable: Throwable) {
                emit(Error(throwable))
                Log.v("ALI", throwable.message.toString())
            }
        }
    }


    override fun searchCharacters(characterName: String): Flow<Resources<List<Character>?>> {
        return flow {
            emit(Loading)
            try {
                val characters = apiService.searchCharacters(characterName).body()?.items?.results?.map { characterDto ->
                    characterMapper.map(characterDto)
                }
                emit(Success(characters))

            } catch (throwable: Throwable) {
                emit(Error(throwable))
                Log.v("ALI", throwable.message.toString())
            }
        }
    }


//    override fun getCharacter() = characterDao.getCharacters()

//
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
}