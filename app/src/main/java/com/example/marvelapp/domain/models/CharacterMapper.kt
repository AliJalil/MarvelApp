package com.example.marvelapp.domain.models

import com.example.marvelapp.domain.mapper.Mapper
import com.example.marvelapp.data.remote.response.CharacterDto

class CharacterMapper:Mapper<CharacterDto, Character> {
    override fun map(input: CharacterDto): Character {
    return  Character(
            name = input.name,
            id = input.id,
            imageUrl = "${input.thumbnail?.path}.${input.thumbnail?.extension}",
        )
    }
}