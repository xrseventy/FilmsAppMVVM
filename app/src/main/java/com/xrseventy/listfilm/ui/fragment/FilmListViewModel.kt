package com.xrseventy.listfilm.ui.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.xrseventy.listfilm.repository.FilmsListRepository
import com.xrseventy.listfilm.data.model.MovieItem


class FilmListViewModel() : ViewModel() {

    private val filmsListRepository: FilmsListRepository = FilmsListRepository()
    private val movieList: MutableLiveData<List<MovieItem>> =
        filmsListRepository.getListOfPopularMovies()

    fun getRecyclerMovieListDataObserver(): LiveData<List<MovieItem>> {
        return movieList
    }

    // private val configurationSet: MutableLiveData<List<String>> = filmsListRepository.getConfigurationOFilmList()
    // private val genresList: LiveData<List<GenresItem>> = filmsListRepository.getListGenres()

}

