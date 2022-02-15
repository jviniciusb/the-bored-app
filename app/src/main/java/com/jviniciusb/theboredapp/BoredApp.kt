package com.jviniciusb.theboredapp

import android.app.Application
import com.jviniciusb.theboredapp.di.BoredModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.core.context.startKoin

class BoredApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startDi()
    }

    private fun startDi() = startKoin {

        androidContext(this@BoredApp)
        androidFileProperties()
        modules(BoredModule.module)
    }
}
