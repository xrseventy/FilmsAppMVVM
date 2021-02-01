package com.xrseventy.listfilm.data.network

import androidx.lifecycle.MutableLiveData
import com.xrseventy.listfilm.data.model.MovieItem


interface LoadFilmListCallBack {
    fun onSuccess(listMovieItem: List<MovieItem>)
    fun onError()
}