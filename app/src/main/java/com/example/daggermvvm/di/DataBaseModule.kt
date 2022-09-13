package com.example.daggermvvm.di

import android.content.Context
import androidx.room.Room
import com.example.daggermvvm.db.FakerDB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideFakerDB(context:Context):FakerDB{
        return Room.databaseBuilder(context,FakerDB::class.java,"FakerDB").build()
    }
}