package com.example.marvelapp.domain

data class HomeItem<T>(
    val item: T,
    val type: HomeItemType,
)