package com.xrseventy.listfilm.data.repository.remote_data_source
import com.my.listFilms.data.repository.remote_data_source.NetworkModule.API_KEY
import com.xrseventy.listfilm.data.model.Configuration
import com.xrseventy.listfilm.data.model.GenresList
import com.xrseventy.listfilm.data.model.PopularMoviesList
import retrofit2.Call
import retrofit2.http.*



interface TheMovieDbApiService {

    @GET("configuration")
     fun getConfiguration(@Query("api_key") apiKey: String = API_KEY): Call<Configuration>


    @GET("movie/popular")
    fun getMoviePopular(@Query("api_key") apiKey: String = API_KEY,  @Query("language") systemLang: String): Call<PopularMoviesList>
    //fun getMoviePopular(@Query("api_key") apiKey: String = API_KEY,  @Query("language") systemLang: String, @Query("page") page: Int): Call<PopularMoviesList> //TODO all pages


    @GET("genre/movie/list")
    fun getGenre(@Query("api_key") apiKey: String = API_KEY,  @Query("language") systemLang: String): Call<GenresList>
}
