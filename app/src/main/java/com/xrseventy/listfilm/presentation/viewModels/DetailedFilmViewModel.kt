package com.xrseventy.listfilm.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.xrseventy.listfilm.data.model.DetailedMovieApi
//import com.xrseventy.listfilm.data.model.DetailedMovie

import com.xrseventy.listfilm.data.network.LoadDetailedMovieCallback
import com.xrseventy.listfilm.data.repository.FilmsListRepository


class DetailedFilmViewModel(private val filmsListRepository: FilmsListRepository) : ViewModel() {
        private var _detailedMovie: MutableLiveData<DetailedMovieApi> = MutableLiveData()
//        private val movieDetailedMapper: MovieMapper = MovieMapper()
        var detailedMovie: LiveData<DetailedMovieApi> = _detailedMovie


        fun loadDetailedMovie(movieId : Int) {
            filmsListRepository.fetchDetailedMovieFromResponseTask(movieId, object : LoadDetailedMovieCallback {
                override fun onSuccess(detailedMovie: DetailedMovieApi) {
                    _detailedMovie.value = detailedMovie
                    //mapDetailedMovie(detailedMovie)
                }

                override fun onError() {
                    TODO("Not yet implemented")
                }

            })
        }
//    private fun mapDetailedMovie(detailedMovie: DetailedMovie) :  DetailedMovie =
//        movieDetailedMapper.mapDetailedMovieInfo(detailedMovie)

}