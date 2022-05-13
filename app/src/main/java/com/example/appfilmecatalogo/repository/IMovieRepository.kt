package com.example.appfilmecatalogo.repository

import com.example.appfilmecatalogo.models.Lives

interface IMovieRepository {
    suspend fun getAllLives(): Lives
}
