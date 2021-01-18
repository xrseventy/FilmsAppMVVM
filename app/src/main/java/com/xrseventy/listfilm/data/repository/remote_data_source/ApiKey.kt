package com.xrseventy.listfilm.data.repository.remote_data_source

import okhttp3.Interceptor
import okhttp3.Response

//
//class ApiKeyInterceptor: Interceptor {
//
//    override fun intercept(chain: Interceptor.Chain): Response {
//        val originalRequest = chain.request()
//        val originalHttpUrl = originalRequest.url
//
//        val url = originalHttpUrl.newBuilder()
//            .addQueryParameter("api_key", API_KEY)
//            .build()
//
//        val requestBuilder = originalRequest.newBuilder().url(url)
//        val request = requestBuilder.build()
//
//        return chain.proceed(request)
//    }
//    }
//const val API_KEY = "923bb540f8268da1eb90ceff700bfe02"
//
