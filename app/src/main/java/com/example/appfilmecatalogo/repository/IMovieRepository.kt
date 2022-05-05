package com.example.appfilmecatalogo.repository

import com.example.appfilmecatalogo.models.Lives
import com.example.appfilmecatalogo.models.movieDetails

interface IMovieRepository{
    suspend fun getAllLives():Lives
}

interface IMovieRepositoryDetails{
    suspend fun getMovieDetail():movieDetails
}