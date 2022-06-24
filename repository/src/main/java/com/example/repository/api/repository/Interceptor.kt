package com.example.repository.api.repository

import com.example.repository.api.Constants
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class Interceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val url =
            chain
                .request()
                .url
                .newBuilder()
                .addQueryParameter("api_key", Constants.API_KEY)
                .build()

        val request: Request = chain
            .request()
            .newBuilder()
            .url(url)
            .build()
        return chain.proceed(request)
    }
}
