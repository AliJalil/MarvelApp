package com.example.marvelapp.ui.base

import androidx.recyclerview.widget.DiffUtil

class MarvelDiffUtils<T>(val marvelOldList: List<T>, val marvelNewList: List<T>) :
    DiffUtil.Callback() {
    override fun getOldListSize() = marvelOldList.size

    override fun getNewListSize() = marvelNewList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        marvelOldList[oldItemPosition] == marvelNewList[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = true
}