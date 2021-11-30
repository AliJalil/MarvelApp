package com.example.marvelapp.ui.home

import com.example.marvelapp.R
import com.example.marvelapp.ui.base.BaseAdapter


class CharacterAdapter(
    items: List<Character>, listener: CharacterInteractionListener
) : BaseAdapter<Character>(items, listener) {
    override val layoutId: Int = R.layout.item_character
}
