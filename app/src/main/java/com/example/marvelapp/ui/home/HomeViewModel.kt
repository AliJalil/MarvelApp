package com.example.marvelapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.marvelapp.domain.MarvelRepository
import com.example.marvelapp.domain.MarvelRepositoryImpl
import com.example.marvelapp.domain.models.Character
import com.example.marvelapp.util.Resources
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel(),CharacterInteractionListener {
    val repository : MarvelRepository = MarvelRepositoryImpl()
    val charecters :LiveData<Resources<List<Character>?>>  = repository.getCharacter().asLiveData(Dispatchers.IO)


//    init {
//        viewModelScope.launch {
//            repository.refreshCharacters()
//        }
//
//    }
}