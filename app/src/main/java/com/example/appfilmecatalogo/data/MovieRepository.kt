package com.example.appfilmecatalogo.data

import androidx.annotation.WorkerThread
import com.example.abstractions.models.Lives
import com.example.abstractions.models.PopularWeeklyFilms
import com.example.database.IDbMovieRepository
import com.example.database.daos.MovieDao
import com.example.repository.api.RetrofitService
import com.example.repository.api.repository.IApiMovieRepository
import kotlinx.coroutines.flow.Flow

class MovieRepository(
    private val movieClient: RetrofitService,
    private val movieDao: MovieDao,
) :
    IApiMovieRepository,
    IDbMovieRepository {
    val allMovies: Flow<MutableList<PopularWeeklyFilms>>? = movieDao.allMoviesFromDB()

    override suspend fun getAllLives(): Lives {
        return movieClient.getAllLives()
    }

    @WorkerThread
    override suspend fun insertToDB(movie: PopularWeeklyFilms) {
        movieDao.insert(movie)
    }

    @WorkerThread
    override suspend fun deleteFromDB(movie: PopularWeeklyFilms) {
        movieDao.delete(movie)
    }
}
