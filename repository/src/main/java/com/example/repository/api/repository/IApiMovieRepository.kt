package com.example.repository.api.repository

import com.example.abstractions.models.Lives

interface IApiMovieRepository {
    suspend fun getAllLives(): Lives
}
