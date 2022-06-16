package com.example.appfilmecatalogo.presenter.view

import com.example.appfilmecatalogo.data.api.HttpClient
import com.example.appfilmecatalogo.data.api.RetrofitService
import com.example.appfilmecatalogo.data.repository.MovieRepository
import com.example.appfilmecatalogo.domain.utils.Constants
import com.example.appfilmecatalogo.presenter.util.MovieViewModelFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FactoryBuilder {
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
        private val movieRepository = MovieRepository(movieClient)
        val movieFactory = MovieViewModelFactory(movieRepository)
    }
}
