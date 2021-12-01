package com.example.marvelapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.marvelapp.data.remote.response.BaseResponse
import com.example.marvelapp.domain.MarvelRepository
import com.example.marvelapp.domain.MarvelRepositoryImpl
import com.example.marvelapp.domain.models.Character
import com.example.marvelapp.util.Resources
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository : MarvelRepository
): ViewModel(),CharacterInteractionListener {

    val charecters  = repository.getCharacters().asLiveData()

//
//    init {
//        viewModelScope.launch {
//            repository.refreshCharacters()
//        }
//
//    }
}