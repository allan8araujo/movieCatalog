package com.example.repository.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object {
        private val retrofitInstanceMain: Retrofit by lazy {
            Retrofit.Builder()
                .client(HttpClient.clientInterceptor)
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        private val movieClient: RetrofitService by lazy {
            retrofitInstanceMain.create(RetrofitService::class.java)
        }
        val movieRepository = movieClient
    }
}
