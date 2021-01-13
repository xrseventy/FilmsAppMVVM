package com.my.weather.data

import com.my.weather.data.response.MovieDetails
import io.reactivex.Single
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TheMovieDbApiService {
    @GET("movie/{movie_id} ")
    fun getMovieDetails(@Path("movie_id")id: Int) : Single<MovieDetails>

    //can used it coroutines Deferred<MovieDetails>
//            companion object {
//        operator fun invoke(): TheMovieDbApiService {
//
//        }
//    }


}




//An example request looks like:
// https://api.themoviedb.org/3/movie/550?api_key=923bb540f8268da1eb90ceff700bfe02