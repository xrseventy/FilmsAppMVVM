package com.xrseventy.listfilm.data.repository.remote_data_source

import com.xrseventy.listfilm.data.repository.model.MovieDetails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

private const val API_KEY = "923bb540f8268da1eb90ceff700bfe02"

interface TheMovieDbApiService {
    @GET("movie/{movie_id} ")
    //fun getMovieDetails(@Path("movie_id") id: Int): Call<MovieDetails>
    fun getMovieDetails(
        @Header("x-api-key") apiKey: String = API_KEY
    ): Call<List<MovieDetails>>
}
