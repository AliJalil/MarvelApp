package com.example.marvelapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.marvelapp.data.local.daos.MarvelCharacterDao
import com.example.marvelapp.data.local.entity.CharacterEntity


@Database(entities = [CharacterEntity::class], version = 1)
abstract class MarvelDatabase : RoomDatabase() {
    abstract fun marvelCharacterDao(): MarvelCharacterDao

    companion object {

        const val DATABASE_NAME = "MarvelDatabase"
//
//        @Volatile
//        private var instance: MarvelDatabase? = null
//
//        fun getInstance(context: Context): MarvelDatabase {
//            return instance ?: synchronized(this) { buildDatabase(context).also { instance = it } }
//        }
//
//        fun getInstanceWithoutContext() :MarvelDatabase{
//            return instance!!
//        }
//
//        private fun buildDatabase(context: Context): MarvelDatabase {
//            return Room.databaseBuilder(context, MarvelDatabase::class.java, DATABASE_NAME)
//                .allowMainThreadQueries().build()
//        }
    }
}