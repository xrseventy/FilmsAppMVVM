package com.my.listFilms.data.repository.remote_data_source

import com.xrseventy.listfilm.data.repository.model.MovieDetails
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
const val API_KEY = "923bb540f8268da1eb90ceff700bfe02"
const val BASE_URL = "https://api.themoviedb.org/3/"
const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface TheMovieDbApiService {
    @GET("movie/{movie_id} ")
    //fun getMovieDetails(@Path("movie_id") id: Int): Call<MovieDetails>
    fun getMovieDetails(): Call<MovieDetails>


    object MoviesApi {
        val retrofitService : TheMovieDbApiService by lazy {
            retrofit.create(TheMovieDbApiService::class.java) }
    }

    //can used it coroutines Deferred<MovieDetails>
//            companion object {
//        operator fun invoke(): TheMovieDbApiService {
//
//        }
//    }



//    companion object {
//        operator fun invoke(): TheMovieDbApiService {
//            return Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//                .create(TheMovieDbApiService::class.java)
//        }

    }






//An example request looks like:
// https://api.themoviedb.org/3/movie/550?api_key=923bb540f8268da1eb90ceff700bfe02