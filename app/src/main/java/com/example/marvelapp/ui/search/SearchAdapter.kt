package com.example.marvelapp.ui.search

import com.example.marvelapp.R
import com.example.marvelapp.ui.base.BaseAdapter
import com.example.marvelapp.domain.models.Character
import com.example.marvelapp.ui.home.CharacterInteractionListener

class SearchAdapter(
    items: List<Character>, listener: CharacterInteractionListener
) : BaseAdapter<Character>(items, listener) {
    override val layoutId: Int = R.layout.item_search
}
