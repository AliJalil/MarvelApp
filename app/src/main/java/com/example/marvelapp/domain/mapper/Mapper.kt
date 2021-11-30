package com.example.marvelapp.domain.mapper

interface Mapper<I, O> {
    fun map (input: I): O
}