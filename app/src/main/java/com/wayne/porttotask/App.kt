package com.wayne.porttotask

import android.app.Application
import com.wayne.porttotask.di.networkModule
import com.wayne.porttotask.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(networkModule, repositoryModule)
        }
    }
}
