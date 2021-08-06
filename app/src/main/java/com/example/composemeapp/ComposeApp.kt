package com.example.composemeapp

import android.app.Application
import com.example.composemeapp.di.allModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

open class ComposeApp : Application() {

    protected open val koinModules = listOf(*allModules)

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@ComposeApp)
            modules(koinModules)
        }
    }
}
