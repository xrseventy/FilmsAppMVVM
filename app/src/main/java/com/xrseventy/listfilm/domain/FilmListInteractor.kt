package com.xrseventy.listfilm.domain

import com.xrseventy.listfilm.data.model.MovieItem
import com.xrseventy.listfilm.data.network.LoadFilmListCallBack
import com.xrseventy.listfilm.data.repository.FilmsListRepository

//Class Interactor united methods for for global task. Interactor = UseCase feature facade.
// Interactor, который включает в себя UseCases.


//class FilmListInteractor(private  val filmsListRepository: FilmsListRepository) {
//
//    fun fetchMovieListFromResponseTask(callBack: LoadFilmListCallBack) {
//
//        filmsListRepository.makeApiCallGetListPopularMovies(object : LoadFilmListCallBack {
//
//            override fun onSuccess(listMovieItem: List<MovieItem>) {
//                callBack.onSuccess(listMovieItem)
//            }
//
//            override fun onError() {
//                callBack.onError()
//            }
//        })
//    }
//}