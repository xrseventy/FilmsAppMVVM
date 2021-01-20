package com.xrseventy.listfilm.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.my.listFilms.data.repository.remote_data_source.NetworkModule.API_KEY
import com.my.listFilms.data.repository.remote_data_source.NetworkModule.theMovieDbApiService
import com.xrseventy.listfilm.data.repository.FilmsListRepository
import com.xrseventy.listfilm.data.repository.model.Configuration
import com.xrseventy.listfilm.data.repository.model.MovieItem
import com.xrseventy.listfilm.data.repository.model.PopularMoviesList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class FilmListViewModel() : ViewModel() {

    var movieList: MutableLiveData<List<MovieItem>> = MutableLiveData()


   // val movieList: LiveData<List<MovieItem>> = filmsListRepository.getListOfPopularMovies()
    // TODO: Implement the ViewModel

    fun getRecyclerMovieListDataObserver(): LiveData<List<MovieItem>>
    {
        return movieList
    }

    fun makeApiCall(){

        val popularMovieCall: Call<PopularMoviesList> = theMovieDbApiService.getMoviePopular(API_KEY, (Locale.getDefault().language.toString()))

        Log.d(this.toString(), "log onResume")
        popularMovieCall.enqueue(object : Callback<PopularMoviesList> {
            override fun onFailure(call: Call<PopularMoviesList>, t: Throwable) {
//                val toastAdd = Toast.makeText(activity, "2", Toast.LENGTH_LONG)
//                toastAdd.setGravity(Gravity.TOP, 0, 170)
//                toastAdd.show()
                movieList.postValue(null)
            }

            override fun onResponse(
                call: Call<PopularMoviesList>,
                response: Response<PopularMoviesList>

            ) {
                val popularMovieList: PopularMoviesList? = response.body()

                val url = response.raw().request().url()
                Log.d(this.toString(), "log onResponse $popularMovieList")
                Log.d(this.toString(), "log PopularMoviesList = $url")

                val item: List<MovieItem> = popularMovieList!!.results
                if(response.isSuccessful){
                    movieList.postValue(item)}
                else{
                    movieList.postValue(null)
                }

                //updateAdapter(item)

                Log.d(this.toString(), "log MOVIE $item")

//                val toastAdd = Toast.makeText(activity, "3", Toast.LENGTH_LONG)
//                toastAdd.setGravity(Gravity.TOP, 0, 170)
//                toastAdd.show()

            }

        })


        val configCall: Call<Configuration> = theMovieDbApiService.getConfiguration()
        configCall.enqueue(object : Callback<Configuration> {
            override fun onResponse(call: Call<Configuration>, response: Response<Configuration>) {
                val urlconfig = response.raw().request().url()

                val modelConfig = response.body()
                Log.d(this.toString(), "url config log = $urlconfig")
                Log.d(this.toString(), " config log = ${modelConfig}")
            }
            override fun onFailure(call: Call<Configuration>, t: Throwable) {
            }

        })

    }
}

