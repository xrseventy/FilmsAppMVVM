package com.xrseventy.listfilm.data.network


import com.xrseventy.listfilm.data.model.DetailedMovieApi

interface LoadDetailedMovieCallback {
    fun onSuccess(detailedMovieApi: DetailedMovieApi)
    fun onError()
}