package com.example.marvelapp

import android.app.Application
import com.example.marvelapp.di.DependencyContainer
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MarvelApplication :Application() {

    val container = DependencyContainer()
    override fun onCreate() {
        super.onCreate()
    }
}