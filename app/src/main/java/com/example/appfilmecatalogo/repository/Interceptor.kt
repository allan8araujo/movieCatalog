package com.example.appfilmecatalogo.repository

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class Interceptor():Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request=chain
            .request()
            .newBuilder()
            .addHeader("api_key","02cb01541d4df0ae3ca93b9d76d74c96")
            .build()
        return chain.proceed(request)
    }
}