package com.jviniciusb.theboredapp

import android.app.Application

class BoredApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startDi()
    }

    private fun startDi(): Nothing = TODO("Not yet implemented")
}
