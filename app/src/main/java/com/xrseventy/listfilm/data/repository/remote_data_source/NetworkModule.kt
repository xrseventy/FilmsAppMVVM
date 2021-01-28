package com.my.listFilms.data.repository.remote_data_source

import com.xrseventy.listfilm.data.repository.remote_data_source.TheMovieDbApiService
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

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


//TODO work interceptor

//    val requestInterceptor = Interceptor { chain ->
//
//            val url: HttpUrl = chain.request()
//                .url()
//                .newBuilder()
//                .addQueryParameter("api_key", API_KEY)
//                .build()
//
//
//            val request: Request = chain.request()
//                .newBuilder()
//                .url(url)
//                .build()
//
//            return chain.proceed(request)
//
//        }
//
//
//    val okHttpClient: OkHttpClient = OkHttpClient.Builder()
//            .addInterceptor(requestInterceptor)
//            .build()
//
//
// add to builder .client(okHttpClient)

//An example request looks like:
// https://api.themoviedb.org/3/movie/550?api_key=923bb540f8268da1eb90ceff700bfe02