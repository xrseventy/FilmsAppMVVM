package com.xrseventy.listfilm.data

import android.content.res.Resources
import androidx.lifecycle.ViewModelProvider
import com.xrseventy.listfilm.data.network.NetworkModule

import com.xrseventy.listfilm.data.repository.FilmsListRepository
import com.xrseventy.listfilm.presentation.filmLIstFragment.DetailedFilmFragment
import com.xrseventy.listfilm.presentation.filmLIstFragment.FilmListFragment
import com.xrseventy.listfilm.presentation.viewModels.DetailedFilmViewModel
import com.xrseventy.listfilm.presentation.viewModels.FilmListViewModel
import com.xrseventy.listfilm.presentation.viewModels.MoviesViewModelFactory

class AppContainer(resources: Resources) {

    private val filmListRepository: FilmsListRepository

    init {
        val networkModule = NetworkModule(resources)
        filmListRepository = FilmsListRepository(networkModule)
    }

    fun getFilmListViewModel(fragment: FilmListFragment): FilmListViewModel {
        return ViewModelProvider(
                fragment,
                MoviesViewModelFactory(filmListRepository)
        ).get(FilmListViewModel::class.java)
    }

    fun getFilmListViewModel(fragment: DetailedFilmFragment): DetailedFilmViewModel {
        return ViewModelProvider(
            fragment,
            MoviesViewModelFactory(filmListRepository)
        ).get(DetailedFilmViewModel::class.java)
    }


}