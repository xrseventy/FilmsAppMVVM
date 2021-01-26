package com.my.listFilms.data.repository.remote_data_source

import com.xrseventy.listfilm.data.repository.remote_data_source.TheMovieDbApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object NetworkModule {
    const val API_KEY = "923bb540f8268da1eb90ceff700bfe02"
    private const val BASE_URL = "https://api.themoviedb.org/3/"
    const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w500"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val theMovieDbApiService: TheMovieDbApiService = retrofit.create()

}

//An example request looks like:
// https://api.themoviedb.org/3/movie/550?api_key=923bb540f8268da1eb90ceff700bfe02