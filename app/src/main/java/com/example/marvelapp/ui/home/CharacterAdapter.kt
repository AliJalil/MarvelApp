package com.example.marvelapp.ui.home

import com.example.marvelapp.R
import com.example.marvelapp.domain.models.Character
import com.example.marvelapp.ui.base.BaseAdapter
import com.example.marvelapp.ui.base.ParentAdapter

class CharacterAdapter(
    items: List<Character>, listener: CharacterInteractionListener
) : BaseAdapter<Character>(items, listener) {
    override val layoutId: Int = R.layout.item_character
}


class HomeAdapter(
    items: List<Character>, listener: CharacterInteractionListener
) : ParentAdapter<Character>(items, listener) {
    override val layoutId: Int = R.layout.item_parent
}

class ChildAdapter<T>(
    items: List<T>, listener: CharacterInteractionListener
) : BaseAdapter<T>(items, listener) {
    override val layoutId: Int = R.layout.item_character
}