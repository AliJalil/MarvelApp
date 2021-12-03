package com.example.marvelapp.ui.home

import android.util.Log
import androidx.lifecycle.*
import com.example.marvelapp.domain.HomeItem
import com.example.marvelapp.domain.MarvelRepository
import com.example.marvelapp.domain.models.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import  com.example.marvelapp.domain.HomeItemType
import com.example.marvelapp.ui.base.BaseViewModel
import com.example.marvelapp.util.Resources
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: MarvelRepository
) : BaseViewModel(), CharacterInteractionListener {

    var charecters: Flow<Resources<List<Character>?>> = repository.getCharacters()
    var items: List<Character>? = mutableListOf<Character>()
    var itemsList = MutableLiveData<MutableList<HomeItem<Any>>>()
    var tempItems = mutableListOf<HomeItem<Any>>()

    init {
        charecters = repository.getCharacters()
        viewModelScope.launch {
            items = charecters.first { it is Resources.Success }.data
            items?.let {
                val tempHomeItem = HomeItem(it, HomeItemType.TYPE_PARENT)
                tempItems.add(tempHomeItem as HomeItem<Any>)
                itemsList.postValue(tempItems)
            }
        }
    }

    override fun onClickCharacter(character: Character) {

    }
}


suspend fun <T> Flow<List<T>>.flattenToList() =
    flatMapConcat { it.asFlow() }.toList()


fun <T> MutableLiveData<T>.notifyObserver() {
    this.value = this.value
}