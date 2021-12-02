package com.example.marvelapp.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelapp.domain.models.Character
import com.example.marvelapp.util.Resources
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


abstract class BaseViewModel : ViewModel() {


    fun <T> collectValue(repoValue: Flow<Resources<List<T>?>>, liveValue: MutableLiveData<Resources<List<T>?>>) {
        viewModelScope.launch {
            repoValue
                .catch { }
                .collect { liveValue.value = it }
        }
    }

}