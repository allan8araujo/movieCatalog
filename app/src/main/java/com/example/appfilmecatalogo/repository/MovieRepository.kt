package com.example.appfilmecatalogo.repository

import com.example.appfilmecatalogo.api.RetrofitService
import com.example.appfilmecatalogo.models.Lives

class MovieRepository(private val movieClient:RetrofitService):IMovieRepository {
    override suspend fun getAllLives(): Lives {
        return movieClient.getAllLives()
    }
}