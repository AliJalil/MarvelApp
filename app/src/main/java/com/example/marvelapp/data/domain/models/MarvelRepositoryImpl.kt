package com.example.marvelapp.data.domain.models

import com.example.marvelapp.data.remote.network.API
import com.example.marvelapp.data.remote.response.BaseResponse
import com.example.marvelapp.data.remote.response.CharecterDto
import com.example.marvelapp.util.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class MarvelRepositoryImpl:MarvelRepository {


    fun <T> wrapWithFlow(endPointResponse: suspend () -> Response<T>): Flow<State<T?>> {
        return flow {
            emit(State.Loading)
            try {
                val result = endPointResponse()
                if (result.isSuccessful) {
                    emit(State.Success(result.body()))
                } else {
                    emit(State.Error(result.message()))
                }
            } catch (e: Exception) {
                State.Error(e.message.toString())
            }
        }
    }





    override fun getCharacter()  =
        wrapWithFlow {
            API.apiService.getCharecters()
        }


    override suspend fun refreshCharacters() {
        TODO("Not yet implemented")
    }
}