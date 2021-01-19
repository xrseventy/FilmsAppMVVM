package com.xrseventy.listfilm.data.repository.remote_data_source

import com.my.listFilms.data.repository.remote_data_source.NetworkModule.API_KEY
import com.xrseventy.listfilm.data.repository.model.Configuration
import com.xrseventy.listfilm.data.repository.model.MovieItem

import com.xrseventy.listfilm.data.repository.model.PopularMoviesList
import retrofit2.Call
import retrofit2.http.*



interface TheMovieDbApiService {
    //@GET("movie/{movie_id} ")
//    @GET()
//    //fun getMovieDetails(@Path("movie_id") id: Int): Call<MovieDetails>
//    fun getMovieDetails(
//    ): Call<List<MovieDetails>>


    //@GET("movie")
    //fun getMovieDetails(): Call<List<MovieDetails>>

    //fun getMovieDetails(@Query("api_key") apiKey: String = API_KEY): Call<List<MovieDetails>>

//    @GET("/movie/popular")
//    fun getListPopularMovies(@Query("api_key") apiKey: String = API_KEY): Call<List<PopularMovies>>)

    @GET("configuration")
     fun getConfiguration(@Query("api_key") apiKey: String = API_KEY): Call<Configuration>


    @GET("movie/popular")
    fun getMoviePopular(@Query("api_key") apiKey: String = API_KEY): Call<PopularMoviesList>
    //fun getMovieDetails(@Path("movie_id") movieId: Int, @Query("api_key") apiKey: String = API_KEY): Call<List<MovieDetails>>

}
