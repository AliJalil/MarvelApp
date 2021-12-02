package com.example.marvelapp.ui.search

import androidx.lifecycle.MutableLiveData
import com.example.marvelapp.domain.MarvelRepository
import com.example.marvelapp.domain.models.Character
import com.example.marvelapp.ui.base.BaseViewModel
import com.example.marvelapp.ui.home.CharacterInteractionListener
import com.example.marvelapp.util.Resources
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository : MarvelRepository
): BaseViewModel(), CharacterInteractionListener {

//    val charecters  = repository.getCharacters().asLiveData()
     val characterName = MutableLiveData<String?>()
    var searchResult = MutableLiveData<Resources<List<Character>?>>()

    fun clearSearchTxt() {
        characterName.postValue("")
    }

    fun searchCharacters() {
        collectValue(repository.searchCharacters(characterName.value.toString()), searchResult)
    }

    override fun onClickCharacter(character: Character) {

    }

//    init {
//        viewModelScope.launch {
//            repository.refreshCharacters()
//        }
//
//    }
}