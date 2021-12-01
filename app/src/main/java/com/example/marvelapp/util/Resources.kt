package com.example.marvelapp.util

sealed class Resources<out T>(val data: T?) {
    class Success<T>(data: T) : Resources<T>(data)
    class Error(val throwable: Throwable) : Resources<Nothing>(null)
    object Loading : Resources<Nothing>(null)

    fun toData() = if (this is Success) data else null

    override fun toString(): String {
        return when (this) {
            is Success -> "Success: $data"
            is Error -> "Error: ${throwable.message}"
            is Loading -> "Loading"
        }
    }
}
