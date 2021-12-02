package com.example.marvelapp.ui.home


import com.example.marvelapp.ui.base.BaseInteractionListener
import com.example.marvelapp.domain.models.Character

interface CharacterInteractionListener  : BaseInteractionListener {
    fun onClickCharacter(character: Character)
}