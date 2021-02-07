package com.xrseventy.listfilm.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.xrseventy.listfilm.data.model.DetailedMovie

import com.xrseventy.listfilm.data.network.LoadDetailedMovieCallback
import com.xrseventy.listfilm.data.repository.FilmsListRepository


class DetailedFilmViewModel(private val filmsListRepository: FilmsListRepository) : ViewModel() {
        private var _detailedMovie: MutableLiveData<DetailedMovie> = MutableLiveData()
        var detailedMovie: LiveData<DetailedMovie> = _detailedMovie


        fun loadDetailedMovie(movieId : Int) {
            filmsListRepository.fetchDetailedMovieFromResponseTask(movieId, object : LoadDetailedMovieCallback {
                override fun onSuccess(detailedMovie: DetailedMovie) {
                    _detailedMovie.value = detailedMovie
                }

                override fun onError() {
                    TODO("Not yet implemented")
                }

            })
        }
}