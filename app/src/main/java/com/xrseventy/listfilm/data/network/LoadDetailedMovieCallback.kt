package com.xrseventy.listfilm.data.network

import com.xrseventy.listfilm.data.model.DetailedMovie

interface LoadDetailedMovieCallback {
    fun onSuccess(detailedMovie: DetailedMovie)
    fun onError()
}