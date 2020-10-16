package com.example.dessert

import android.app.Application
import timber.log.Timber

class DessertClicker : Application(){
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}