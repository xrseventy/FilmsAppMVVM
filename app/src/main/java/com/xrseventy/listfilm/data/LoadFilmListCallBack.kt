package com.xrseventy.listfilm.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.xrseventy.listfilm.data.model.MovieItem
import com.xrseventy.listfilm.data.model.PopularMoviesList

interface LoadFilmListCallBack {
    fun onSuccess(listMovieItem: MutableLiveData<List<MovieItem>>)
    fun onError()
}