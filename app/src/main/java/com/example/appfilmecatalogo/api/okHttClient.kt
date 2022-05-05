package com.example.appfilmecatalogo.api

import com.example.appfilmecatalogo.repository.Interceptor
import okhttp3.OkHttpClient

object HttpClient {
    val clientInterceptor by lazy {
        OkHttpClient
            .Builder()
            .addInterceptor(Interceptor())
            .build()
    }
}