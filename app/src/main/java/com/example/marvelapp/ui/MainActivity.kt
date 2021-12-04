package com.example.marvelapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.marvelapp.R
import com.example.marvelapp.data.local.MarvelDatabase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        MarvelDatabase.getInstance(applicationContext)
//        (application as MarvelApplication).container
    }
}