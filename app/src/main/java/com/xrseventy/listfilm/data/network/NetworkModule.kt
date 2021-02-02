package com.my.listFilms.data.repository.remote_data_source

import android.content.res.Resources

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

class NetworkModule(resources: Resources) {

    private val apiKey: String = resources.getString(R.string.api_key)
    private val apiKeyHeader = resources.getString(R.string.api_key_header)
    private val baseUrl: String = resources.getString(R.string.base_url)
    private val languageHeader = resources.getString(R.string.language_header)
    private var getSystemLanguage = (Locale.getDefault().language.toString())


    private val requestInterceptor = Interceptor { chain ->

        val url: HttpUrl = chain.request()
                .url()
                .newBuilder()
                .addQueryParameter(apiKeyHeader, apiKey)
                .addQueryParameter(languageHeader, getSystemLanguage)
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
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val theMovieDbApiService: TheMovieDbApiService = retrofit.create()


}

//An example request looks like:
// https://api.themoviedb.org/3/movie/550?api_key=923bb540f8268da1eb90ceff700bfe02