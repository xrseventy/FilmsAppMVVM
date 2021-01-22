package com.xrseventy.listfilm.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.my.listFilms.data.repository.remote_data_source.NetworkModule.API_KEY
import com.my.listFilms.data.repository.remote_data_source.NetworkModule.theMovieDbApiService
import com.xrseventy.listfilm.data.repository.FilmsListRepository
import com.xrseventy.listfilm.data.repository.model.Configuration
import com.xrseventy.listfilm.data.repository.model.MovieItem
import com.xrseventy.listfilm.data.repository.model.PopularMoviesList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


class FilmListViewModel() : ViewModel() {

    private val filmsListRepository: FilmsListRepository = FilmsListRepository()
    private val movieList: MutableLiveData<List<MovieItem>> =
        filmsListRepository.getListOfPopularMovies()

    fun getRecyclerMovieListDataObserver(): LiveData<List<MovieItem>> {
        return movieList
    }

}

