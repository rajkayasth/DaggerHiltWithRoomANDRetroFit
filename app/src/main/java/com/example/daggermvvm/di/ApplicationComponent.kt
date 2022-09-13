package com.example.daggermvvm.di

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.daggermvvm.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModlue::class,DataBaseModule::class,ViewModelModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)

    fun getMap() : Map<Class<*>,ViewModel>

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}