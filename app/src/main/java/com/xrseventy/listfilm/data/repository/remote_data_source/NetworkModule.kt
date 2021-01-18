package com.my.listFilms.data.repository.remote_data_source

import com.xrseventy.listfilm.data.repository.model.MovieDetails
import com.xrseventy.listfilm.data.repository.remote_data_source.TheMovieDbApiService
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Path

object NetworkModule {
    const val API_KEY = "923bb540f8268da1eb90ceff700bfe02"
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342"


    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    val theMovieDbApiService: TheMovieDbApiService = retrofit.create()

    //FIX ME

}


//On Coroutine
//interface TheMovieDbApiService {
//    }
//
//    @GET("movie/{movie_id} ")
//    fun getMovieDetails(@Path("movie_id") id: Int): Call<MovieDetails>
//    //suspend fun getMovieDetails(): List<MovieDetails>
//}




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








//An example request looks like:
// https://api.themoviedb.org/3/movie/550?api_key=923bb540f8268da1eb90ceff700bfe02