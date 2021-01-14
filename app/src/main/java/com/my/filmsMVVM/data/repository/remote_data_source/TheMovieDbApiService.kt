package com.my.filmsMVVM.data.repository.remote_data_source

import com.my.filmsMVVM.data.BASE_URL
import com.my.filmsMVVM.data.response.MovieDetails
import io.reactivex.Single
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TheMovieDbApiService {
    @GET("movie/{movie_id} ")
    fun getMovieDetails(@Path("movie_id") id: Int): Call<MovieDetails>

    //can used it coroutines Deferred<MovieDetails>
//            companion object {
//        operator fun invoke(): TheMovieDbApiService {
//
//        }
//    }
    companion object {
        operator fun invoke(): TheMovieDbApiService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TheMovieDbApiService::class.java)
        }

    }
}




//An example request looks like:
// https://api.themoviedb.org/3/movie/550?api_key=923bb540f8268da1eb90ceff700bfe02