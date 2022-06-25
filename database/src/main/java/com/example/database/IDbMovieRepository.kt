package com.example.database

import com.example.abstractions.models.PopularWeeklyFilms

interface IDbMovieRepository {
    suspend fun insertToDB(movie: PopularWeeklyFilms)
    suspend fun deleteFromDB(movie: PopularWeeklyFilms)
}
