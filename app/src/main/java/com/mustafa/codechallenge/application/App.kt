package com.mustafa.codechallenge.application

import android.app.Application
import com.mustafa.codechallenge.di.module.appModule
import com.mustafa.codechallenge.di.module.repoModule
import com.mustafa.codechallenge.di.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(appModule, repoModule, viewModelModule))
        }
    }
}