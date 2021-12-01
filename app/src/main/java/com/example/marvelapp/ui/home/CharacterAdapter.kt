package com.example.marvelapp.ui.home

import com.example.marvelapp.R
import com.example.marvelapp.ui.base.BaseAdapter
import com.example.marvelapp.domain.models.Character

class CharacterAdapter(
    items: List<Character>, listener: CharacterInteractionListener
) : BaseAdapter<Character>(items, listener) {
    override val layoutId: Int = R.layout.item_character
}
