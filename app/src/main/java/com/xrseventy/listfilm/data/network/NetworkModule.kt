package com.my.listFilms.data.repository.remote_data_source

import android.content.res.Resources
import android.provider.Settings.Global.getString
import androidx.annotation.StringRes
import com.my.listFilms.data.repository.remote_data_source.NetworkModule.okHttpClient
import com.xrseventy.listfilm.R
import com.xrseventy.listfilm.data.network.TheMovieDbApiService
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.*

object NetworkModule {


    //var API_KEY : String = Resources.getSystem().getString(R.string.API_KEY)
   const val API_KEY = "923bb540f8268da1eb90ceff700bfe02"
    private const val BASE_URL = "https://api.themoviedb.org/3/"
    private const val API_KEY_HEADER = "api_key"
    private const val LANGUAGE_HEADER = "language"
    private  var SET_SYSTEM_LANGUAGE = (Locale.getDefault().language.toString())
    const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w500"

    private val requestInterceptor = Interceptor { chain ->

        val url: HttpUrl = chain.request()
                .url()
                .newBuilder()
                .addQueryParameter(API_KEY_HEADER, API_KEY)
                .addQueryParameter(LANGUAGE_HEADER, SET_SYSTEM_LANGUAGE)
                .build()

        val request: Request = chain.request()
                .newBuilder()
                .url(url)
                .build()

        return@Interceptor chain.proceed(request)

    }

    val okHttpClient: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
            .build()

    private val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val theMovieDbApiService: TheMovieDbApiService = retrofit.create()


}

//An example request looks like:
// https://api.themoviedb.org/3/movie/550?api_key=923bb540f8268da1eb90ceff700bfe02