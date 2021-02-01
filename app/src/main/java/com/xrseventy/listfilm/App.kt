package com.xrseventy.listfilm

import android.app.Application
import com.xrseventy.listfilm.presentation.viewModel.FilmListViewModelFactory

class App : Application() {

    override fun onCreate() {
        super.onCreate()

    }
    val filmListViewModelFactory: FilmListViewModelFactory = FilmListViewModelFactory()

}