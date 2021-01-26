package com.xrseventy.listfilm.ui.fragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.xrseventy.listfilm.data.model.Configuration
import com.xrseventy.listfilm.data.repository.FilmsListRepository
import com.xrseventy.listfilm.data.model.MovieItem


class FilmListViewModel() : ViewModel() {

    private val filmsListRepository: FilmsListRepository = FilmsListRepository()
   // private val configurationSet: MutableLiveData<List<String>> = filmsListRepository.getConfigurationOFilmList()
    private val movieList: MutableLiveData<List<MovieItem>> =
        filmsListRepository.getListOfPopularMovies()



//    fun getConfiguration(): LiveData<List<String>> {
//        Log.d(this.toString(), "log ${configurationSet.toString()}")
//        return configurationSet
//    }
    fun getRecyclerMovieListDataObserver(): LiveData<List<MovieItem>> {
        return movieList
    }





}

