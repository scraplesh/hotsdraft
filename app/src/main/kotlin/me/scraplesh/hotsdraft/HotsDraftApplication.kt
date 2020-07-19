package me.scraplesh.hotsdraft

import android.app.Application
import me.scraplesh.hotsdraft.di.koinModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class HotsDraftApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        setupDi()
    }

    private fun setupDi() {
        startKoin {
            androidLogger()
            androidContext(this@HotsDraftApplication)
            modules(koinModules)
        }
    }
}
