package com.xrseventy.listfilm.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.xrseventy.listfilm.data.repository.FilmsListRepository
import com.xrseventy.listfilm.data.model.MovieItem


class FilmListViewModel() : ViewModel() {

    var lastElemOfList = false
    private val filmsListRepository: FilmsListRepository = FilmsListRepository()
    private val movieList: MutableLiveData<List<MovieItem>> =
        filmsListRepository.getListOfPopularMovies()



    fun getRecyclerMovieListDataObserver(): LiveData<List<MovieItem>> {
        return movieList
    }





}

