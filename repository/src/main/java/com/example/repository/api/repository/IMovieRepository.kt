package com.example.repository.api.repository

interface IMovieRepository {
    suspend fun getAllLives(): com.example.abstractions.models.Lives
}
