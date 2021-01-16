package com.xrseventy.listfilm.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.my.listFilms.data.repository.remote_data_source.TheMovieDbApiService
import com.xrseventy.listfilm.data.repository.model.MovieDetails
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

//    private fun getMarsRealEstateProperties() {
//        _response.value = "Set the Mars API Response here!"
//    }
}