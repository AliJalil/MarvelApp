package com.example.marvelapp.domain

import com.example.marvelapp.util.Resources

data class HomeItem<T>(
    val myItem: List<T>,
    val type: HomeItemType,
)

data class HomeItemx<T>(
    val myItem: T,
    val type: HomeItemType,
)