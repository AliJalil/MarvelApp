package com.example.marvelapp.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.marvelapp.domain.MarvelRepository
import com.example.marvelapp.domain.models.Character
import com.example.marvelapp.ui.base.BaseViewModel
import com.example.marvelapp.ui.home.CharacterInteractionListener
import com.example.marvelapp.util.Resources
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: MarvelRepository
) : BaseViewModel(), CharacterInteractionListener {

    val characterName = MutableStateFlow("")
    private var _searchResult = MutableLiveData<List<Character>>()
    val searchResult: LiveData<List<Character>>
            get() = _searchResult

    init {
        viewModelScope.launch {
            characterName.debounce(1000).collect {
                _searchResult.postValue(repository.searchCharacters(characterName.value))
            }
        }
    }

    override fun onClickCharacter(character: Character) {

    }

}