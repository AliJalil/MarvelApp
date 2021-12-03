package com.example.marvelapp.domain.models

import com.example.marvelapp.data.local.entity.CharacterEntity
import com.example.marvelapp.domain.mapper.Mapper
import com.example.marvelapp.data.remote.response.CharacterDto

interface CharacterBaseMapper {
    fun mapRemoteToDomain(input: CharacterDto): Character
    fun mapRemoteToEntity(input: CharacterDto): CharacterEntity
    fun mapEntityToDomain(input: CharacterEntity): Character
    fun mapDomainToEntity(input: Character): CharacterEntity

}

class CharacterMapper : CharacterBaseMapper {
    override fun mapRemoteToDomain(input: CharacterDto): Character {
        return Character(
            name = input.name,
            id = input.id,
            imageUrl = "${input.thumbnail?.path}.${input.thumbnail?.extension}",
            modified = input.modified,
            description = input.description
        )
    }

    override fun mapRemoteToEntity(input: CharacterDto): CharacterEntity {
        return CharacterEntity(
            id = input.id?.toLong() ?: 0L,
            name = input.name ?: "",
            description = input.description ?: "",
            modified = input.modified ?: "",
            imageUrl = "${input.thumbnail!!.path}.${input.thumbnail!!.extension}"
        )
    }

    override fun mapEntityToDomain(input: CharacterEntity): Character {
        return Character(
            name = input.name,
            id = input.id.toInt(),
            imageUrl = input.imageUrl,
            modified = input.modified,
            description = input.description
        )
    }

    override fun mapDomainToEntity(input: Character): CharacterEntity {
        return CharacterEntity(
            id = input.id?.toLong() ?: 0L,
            name = input.name ?: "",
            description = input.description ?: "",
            modified = input.modified ?: "",
            imageUrl = input.imageUrl ?: "",
        )
    }

}

