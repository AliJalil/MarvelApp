package com.example.marvelapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.marvelapp.domain.HomeItem
import com.example.marvelapp.domain.MarvelRepository
import com.example.marvelapp.domain.models.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import  com.example.marvelapp.domain.HomeItemType
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.toList


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository : MarvelRepository
): ViewModel(),CharacterInteractionListener {

    val charecters  = repository.getCharacters()
    val itemsList: MutableList<HomeItem<Any>> = mutableListOf()

   init {

       itemsList.add(HomeItem(charecters.asLiveData(), HomeItemType.TYPE_PARENT))
//       itemsList.add(HomeItem("Hello", HomeItemType.TYPE_CHILD))
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