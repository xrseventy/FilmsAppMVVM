package com.xrseventy.listfilm

import android.app.Application
import com.xrseventy.listfilm.data.AppContainer

class App : Application() {


    lateinit var appContainer: AppContainer

    override fun onCreate() {
        super.onCreate()

        appContainer = AppContainer(resources)
    }

}