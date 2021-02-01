package com.xrseventy.listfilm.domain

import androidx.lifecycle.LiveData
import com.xrseventy.listfilm.data.LoadFilmListCallBack
import com.xrseventy.listfilm.data.model.MovieItem
import com.xrseventy.listfilm.data.model.PopularMoviesList
import com.xrseventy.listfilm.repository.FilmsListRepository

//Class Interactor united methods for for global task. Interactor = UseCase feature facade.
// Interactor, который включает в себя UseCases.


class FilmListInteractor(private  val filmsListRepository: FilmsListRepository) {
//    fun fetchMovieListFromResponceTask(callBack: LoadFilmListCallBack){
//
//        filmsListRepository.makeApiCallGetListPopularMovies(object : LoadFilmListCallBack {
//
//            override fun onSuccess(movieList: LiveData<PopularMoviesList>) {
//                callBack.onSuccess(movieList)
//            }
//
//            override fun onError() {
//                    callBack.onError()
//                }
//
//            })
//
//    }
}