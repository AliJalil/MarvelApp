package com.example.marvelapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.marvelapp.domain.MarvelRepository
import com.example.marvelapp.ui.home.HomeViewModel

//class MarvelViewModelFactory(private val repository: MarvelRepository) :ViewModelProvider.Factory {
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//       when(modelClass)
//       {
//           HomeViewModel::class.java->  HomeViewModel(repository)
//       }
//        throw Throwable("UNDEFINED_VIEW_MODEL")
//    }
//}