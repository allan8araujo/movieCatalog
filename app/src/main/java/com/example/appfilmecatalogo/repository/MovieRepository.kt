package com.example.appfilmecatalogo.repository

import com.example.appfilmecatalogo.api.RetrofitService
import com.example.appfilmecatalogo.api.RetrofitServiceDetail
import com.example.appfilmecatalogo.models.Lives
import com.example.appfilmecatalogo.models.movieDetails
import okhttp3.OkHttpClient

class MovieRepository(private val movieClient:RetrofitService):IMovieRepository {
    override suspend fun getAllLives(): Lives {
        return movieClient.getAllLives()
    }
}

class MovieRepositoryDetails(private val movieDetailsClient:RetrofitServiceDetail):IMovieRepositoryDetails{
    override suspend fun getMovieDetail(): movieDetails {
        return movieDetailsClient.getMovieDetail()
    }
}