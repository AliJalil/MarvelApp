package com.example.marvelapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CharacterEntity(
    @PrimaryKey var id: Long,
    var name: String,
    var description: String,
     var modified: String,
    var imageUrl : String

)