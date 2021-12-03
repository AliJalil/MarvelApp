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
//    val itemsList: MutableList<HomeItem<Any>> = mutableListOf()
    var items: List<Character>? = mutableListOf()


   var itemsList = MutableLiveData<MutableList<HomeItem<Any>>>()


    init {
        charecters = repository.getCharacters()

        viewModelScope.launch {
             items = charecters.first { it is Resources.Success }.data
            Log.v("ALLLI items", items.toString())

            itemsList.value?.add(HomeItem(items.orEmpty(), HomeItemType.TYPE_PARENT))
            Log.v("ALLLI", itemsList.toString())

            itemsList.notifyObserver()
        }



    }

    override fun onClickCharacter(character: Character) {

    }

//
//    init {
//        viewModelScope.launch {
//            repository.refreshCharacters()
//        }
//
//    }
}

suspend fun <T> Flow<List<T>>.flattenToList() =
    flatMapConcat { it.asFlow() }.toList()


fun <T> MutableLiveData<T>.notifyObserver() {
    this.value = this.value
}