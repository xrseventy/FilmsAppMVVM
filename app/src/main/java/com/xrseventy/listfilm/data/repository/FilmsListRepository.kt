package com.xrseventy.listfilm.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import com.my.listFilms.data.repository.remote_data_source.NetworkModule
import com.xrseventy.listfilm.data.model.Configuration
import com.xrseventy.listfilm.data.model.MovieItem
import com.xrseventy.listfilm.data.model.PopularMoviesList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


class FilmsListRepository {

    private fun makeApiCallGetListPopularMovies(): LiveData<PopularMoviesList> {

        val popularMovieList = MutableLiveData<PopularMoviesList>()

        val popularMovieCall: Call<PopularMoviesList> =
            NetworkModule.theMovieDbApiService.getMoviePopular(
                NetworkModule.API_KEY,
                (Locale.getDefault().language.toString())
            )

        popularMovieCall.enqueue(object : Callback<PopularMoviesList> {

            override fun onFailure(call: Call<PopularMoviesList>, t: Throwable) {
                popularMovieList.postValue(null)
            }

            override fun onResponse(
                call: Call<PopularMoviesList>,
                response: Response<PopularMoviesList>

            ) {
                val url = response.raw().request().url()
                Log.d(this.toString(), "log url = $url")

                popularMovieList.value = response.body()
//                Log.d(this.toString(), "log onResponse $popularMovieList")
//                val item: List<MovieItem> = popularMovieList.value!!.results
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

//    private fun getConfigurationApiCall() : Configuration{
//        Log.d(this.toString(), "log 2")
//
//        val configurationTheMovieDb = MutableLiveData<Configuration>()
//
//        val configurationCall: Call<Configuration> =
//            NetworkModule.theMovieDbApiService.getConfiguration(NetworkModule.API_KEY
//            )
//
//        configurationCall.enqueue(object : Callback<Configuration> {
//
//            override fun onFailure(call: Call<Configuration>, t: Throwable) {
//                configurationTheMovieDb.postValue(null)
//                Log.d(this.toString(), "log 3")
//            }
//
//            override fun onResponse(
//                call: Call<Configuration>,
//                response: Response<Configuration>
//
//            ) {
//                Log.d(this.toString(), "log 4")
//                configurationTheMovieDb.value = response.body()
//                val url = response.raw().request().url()
//                Log.d(this.toString(), "log url = $url")
//
//            }
//        })
//        return configurationTheMovieDb
//
//    }
//
//
//
//    fun getConfigurationOfImages() : String {
//        Log.d(this.toString(), "log 1")
//        val configurationTheMovieDb = getConfigurationApiCall()
//        conf
//        return configurationTheMovieDb.map { Configuration ->  Configuration.images.baseUrl.toString()}
//
//    }


    fun getListOfPopularMovies(): MutableLiveData<List<MovieItem>> {
        val popularList = makeApiCallGetListPopularMovies()


        return popularList.map { PopularMoviesList ->  PopularMoviesList.results} as MutableLiveData<List<MovieItem>>

    }
}