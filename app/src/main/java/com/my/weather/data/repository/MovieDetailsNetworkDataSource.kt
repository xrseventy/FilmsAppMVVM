package com.my.weather.data.repository

import com.my.weather.data.TheMovieDbApiService
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsNetworkDataSource (private val apiService: TheMovieDbApiService, val compositeDisposable: CompositeDisposable)
{

}