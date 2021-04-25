package com.xrseventy.listfilm.data.repository

import com.xrseventy.listfilm.data.model.DetailedMovieApi

import com.xrseventy.listfilm.data.network.NetworkModule
import com.xrseventy.listfilm.data.network.LoadFilmListCallBack
import com.xrseventy.listfilm.data.model.MovieItem
import com.xrseventy.listfilm.data.model.PopularMoviesList
import com.xrseventy.listfilm.data.network.LoadDetailedMovieCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilmsListRepository(private val networkModule: NetworkModule) {

    private fun makeApiCallGetListPopularMovies(callback: LoadFilmListCallBack) {

        var popularMovieList: PopularMoviesList
        val popularMovieCall: Call<PopularMoviesList> =
            networkModule.theMovieDbApiService.getMoviePopular()

        popularMovieCall.enqueue(object : Callback<PopularMoviesList> {

            override fun onFailure(call: Call<PopularMoviesList>, t: Throwable) {
                callback.onError()
            }

            override fun onResponse(
                call: Call<PopularMoviesList>,
                response: Response<PopularMoviesList>
            ) {
                if (response.isSuccessful) {
                    popularMovieList = response.body()!!
                    callback.onSuccess(popularMovieList.results)
                } else {
                    callback.onError()
                }
            }
        })
    }

    fun fetchMovieListFromResponseTask(callBack: LoadFilmListCallBack) {

        makeApiCallGetListPopularMovies(object : LoadFilmListCallBack {

            override fun onSuccess(listMovieItem: List<MovieItem>) {
                callBack.onSuccess(listMovieItem)
            }

            override fun onError() {
                callBack.onError()
            }
        })
    }


    private fun makeApiCallGetDetailedMovie(callback: LoadDetailedMovieCallback, movieId: Int) {

        var detailedMovie: DetailedMovieApi
        val detailedMovieCall: Call<DetailedMovieApi> =
            networkModule.theMovieDbApiService.getDetailedMovie(movieId)

        detailedMovieCall.enqueue(object : Callback<DetailedMovieApi> {

            override fun onFailure(call: Call<DetailedMovieApi>, t: Throwable) {
                callback.onError()
            }

            override fun onResponse(
                call: Call<DetailedMovieApi>,
                response: Response<DetailedMovieApi>
            ) {
                if (response.isSuccessful) {
                    detailedMovie = response.body()!!
                    callback.onSuccess(detailedMovie)
                } else {
                    callback.onError()
                }
            }
        })
    }

    fun fetchDetailedMovieFromResponseTask(movieID: Int, callBack: LoadDetailedMovieCallback) {

        makeApiCallGetDetailedMovie(object : LoadDetailedMovieCallback {

            override fun onSuccess(listMovieItem: DetailedMovieApi) {
                callBack.onSuccess(listMovieItem)
            }

            override fun onError() {
                callBack.onError()
            }
        }, movieID)
    }

}