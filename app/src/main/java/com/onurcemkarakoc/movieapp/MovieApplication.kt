package com.onurcemkarakoc.movieapp

import android.app.Application
import com.onurcemkarakoc.movieapp.di.apiModule
import com.onurcemkarakoc.movieapp.di.repositoryModule
import com.onurcemkarakoc.movieapp.di.retrofitModule
import com.onurcemkarakoc.movieapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MovieApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MovieApplication)
            modules(listOf(retrofitModule, apiModule, viewModelModule, repositoryModule))
        }
    }
}