package com.example.appfilmecatalogo.data

import com.example.abstractions.models.Lives
import com.example.repository.api.RetrofitService
import com.example.repository.api.repository.IMovieRepository

class MovieRepository(private val movieClient: RetrofitService) : IMovieRepository {
    override suspend fun getAllLives(): Lives {
        return movieClient.getAllLives()
    }
}
