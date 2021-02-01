package com.xrseventy.listfilm.data

import androidx.lifecycle.MutableLiveData
import com.xrseventy.listfilm.data.model.MovieItem

interface LoadFilmListCallBack {
    fun onSuccess(listMovieItem: MutableLiveData<List<MovieItem>>)
    fun onError()
}