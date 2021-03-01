package com.xrseventy.listfilm.data.network

import com.xrseventy.listfilm.data.model.MovieItem

interface LoadFilmListCallBack {
    fun onSuccess(listMovieItem: List<MovieItem>)
    fun onError()
}