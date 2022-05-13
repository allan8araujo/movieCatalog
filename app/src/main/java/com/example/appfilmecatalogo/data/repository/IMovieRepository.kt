package com.example.appfilmecatalogo.data.repository

import com.example.appfilmecatalogo.domain.models.Lives

interface IMovieRepository {
    suspend fun getAllLives(): Lives
}
