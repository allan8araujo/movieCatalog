package com.example.repository.api

import com.example.repository.api.repository.Interceptor
import okhttp3.OkHttpClient

object HttpClient {
    val clientInterceptor by lazy {
        OkHttpClient
            .Builder()
            .addInterceptor(Interceptor())
            .build()
    }
}
