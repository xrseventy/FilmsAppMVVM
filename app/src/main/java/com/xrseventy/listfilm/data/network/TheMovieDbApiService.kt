package com.xrseventy.listfilm.data.network


import com.xrseventy.listfilm.data.model.DetailedMovieApi
import com.xrseventy.listfilm.data.model.PopularMoviesList
import retrofit2.Call
import retrofit2.http.*

interface TheMovieDbApiService {

    @GET("movie/popular")
    fun getMoviePopular(): Call<PopularMoviesList>
    //fun getMoviePopular(@Query("page") page: Int): Call<PopularMoviesList> //TODO all pages

    @GET("movie/{movie_id}")
    fun getDetailedMovie(@Path("movie_id")movieId: Int): Call<DetailedMovieApi>

}
