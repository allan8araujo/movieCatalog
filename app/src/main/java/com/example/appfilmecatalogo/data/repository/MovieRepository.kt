package com.example.appfilmecatalogo.data.repository

import com.example.appfilmecatalogo.data.api.RetrofitService
import com.example.appfilmecatalogo.domain.models.Lives

class MovieRepository(private val movieClient:RetrofitService):IMovieRepository {
    override suspend fun getAllLives(): Lives {
        return movieClient.getAllLives()
    }
}