package com.george_georgy.eldokana

import android.app.Application
import com.george_georgy.eldokana.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class EldokanaApp : Application() {

    // once application is created we need to initialize koin
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree());
        startKoin {
            androidContext(this@EldokanaApp)
            modules(provideModules())
        }
    }

    private fun provideModules() = listOf(appModule,)

}