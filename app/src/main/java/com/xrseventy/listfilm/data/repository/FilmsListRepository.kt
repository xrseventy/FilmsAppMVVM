package com.xrseventy.listfilm.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations.map
import androidx.lifecycle.map
import com.google.gson.annotations.SerializedName
import com.my.listFilms.data.repository.remote_data_source.NetworkModule
import com.xrseventy.listfilm.data.repository.model.MovieItem
import com.xrseventy.listfilm.data.repository.model.PopularMoviesList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


class FilmsListRepository {
//    private val webservice: TheMovieDbApiService = TODO()
//    // ...
//    fun getMovieDetails(movieId: String): LiveData<MovieDetails> {
//        // This isn't an optimal implementation. We'll fix it later.
//        val data = MutableLiveData<MovieDetails>()
//
//        webservice.getMovieDetails().enqueue(object : Callback<MovieDetails> {
//            override fun onResponse(call: Call<MovieDetails>, response: Response<MovieDetails>) {
//                data.value = response.body()
//            }
//            // Error case is left out for brevity.
//            override fun onFailure(call: Call<MovieDetails>, t: Throwable) {
//                TODO()
//            }
//        })
//        return data
//    }

    fun makeApiCallGetListPopularMovies(): LiveData<PopularMoviesList> {

        val movieList = MutableLiveData<List<MovieItem>>()

        val popularMovieList = MutableLiveData<PopularMoviesList>()

        val popularMovieCall: Call<PopularMoviesList> =
            NetworkModule.theMovieDbApiService.getMoviePopular(
                NetworkModule.API_KEY, (Locale.getDefault().language.toString())
            )

        Log.d(this.toString(), "log onResume")
        popularMovieCall.enqueue(object : Callback<PopularMoviesList> {
            override fun onFailure(call: Call<PopularMoviesList>, t: Throwable) {
                movieList.postValue(null)
            }

            override fun onResponse(
                call: Call<PopularMoviesList>,
                response: Response<PopularMoviesList>

            ) {
                popularMovieList.value = response.body()

//                val url = response.raw().request().url()
//                Log.d(this.toString(), "log onResponse $popularMovieList")
//                Log.d(this.toString(), "log PopularMoviesList = $url")
//                val item: List<MovieItem> = popularMovieList!!.results
//                if (response.isSuccessful) {
//                    movieList.postValue(item)
//                } else {
//                    movieList.postValue(null)
//                }
//                Log.d(this.toString(), "log MOVIE $item")
            }
        })
        return popularMovieList
    }


//        val configCall: Call<Configuration> = NetworkModule.theMovieDbApiService.getConfiguration()
//        configCall.enqueue(object : Callback<Configuration> {
//            override fun onResponse(call: Call<Configuration>, response: Response<Configuration>) {
//                val urlconfig = response.raw().request().url()
//
//                val modelConfig = response.body()
//                Log.d(this.toString(), "url config log = $urlconfig")
//                Log.d(this.toString(), " config log = ${modelConfig}")
//            }
//            override fun onFailure(call: Call<Configuration>, t: Throwable) {
//            }
//
//        })


    fun getListOfPopularMovies(): LiveData<List<MovieItem>> {
        val popularList = makeApiCallGetListPopularMovies()

        val resultsMovieList = popularList.map { PopularMoviesList ->  PopularMoviesList.results}
     return resultsMovieList

//        val userLD : LiveData<User> = ...;
//        val userFullNameLD: LiveData<String> = userLD.map { user -> u



    }


}