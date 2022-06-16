package com.example.appfilmecatalogo.data.api

import com.example.appfilmecatalogo.data.repository.Interceptor
import okhttp3.OkHttpClient

object HttpClient {
    val clientInterceptor by lazy {
        OkHttpClient
            .Builder()
            .addInterceptor(Interceptor())
            .build()
    }
}
