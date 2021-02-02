package com.xrseventy.listfilm.data

import android.content.res.Resources
import androidx.lifecycle.ViewModelProvider
import com.my.listFilms.data.repository.remote_data_source.NetworkModule

import com.xrseventy.listfilm.data.repository.FilmsListRepository
import com.xrseventy.listfilm.presentation.filmLIstFragment.FilmListFragment
import com.xrseventy.listfilm.presentation.viewModel.FilmListViewModel
import com.xrseventy.listfilm.presentation.viewModel.FilmListViewModelFactory

class AppContainer(resources: Resources) {

    private val filmListRepository: FilmsListRepository

    init {
        val networkModule = NetworkModule(resources)
        filmListRepository = FilmsListRepository(networkModule)
    }

    fun getFilmListViewModel(fragment: FilmListFragment): FilmListViewModel {
        return ViewModelProvider(
                fragment,
                FilmListViewModelFactory(filmListRepository)
        ).get(FilmListViewModel::class.java)
    }


}