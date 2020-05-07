package com.onurcemkarakoc.movieapp.di

import com.onurcemkarakoc.movieapp.ui.main.MainActivity
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class,NetworkModule::class])
interface AppComponent{
    fun inject(mainActivity: MainActivity)
}