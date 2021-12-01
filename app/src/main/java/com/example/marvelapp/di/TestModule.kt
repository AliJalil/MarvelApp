package com.example.marvelapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Named

@Module
@InstallIn(ActivityComponent::class)
class TestModule {

    @Provides
    @Named("first_string")
    fun providerString() :String
    {
        return "Hello I'm first"
    }

    @Provides
    @Named("second_string")
    fun providerAnotherString() :String
    {
        return "Hello I'm another"
    }


}