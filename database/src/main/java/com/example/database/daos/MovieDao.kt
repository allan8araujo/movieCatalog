package com.example.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.abstractions.models.PopularWeeklyFilms
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Query("SELECT * FROM movie_list")
    fun allMoviesFromDB(): Flow<List<PopularWeeklyFilms?>>

    @Insert
    suspend fun insert(movie: PopularWeeklyFilms)

    @Delete
    suspend fun delete(movie: PopularWeeklyFilms)
}
