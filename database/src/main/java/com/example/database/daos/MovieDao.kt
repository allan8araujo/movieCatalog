package com.example.database.daos

import androidx.room.*
import com.example.abstractions.models.PopularWeeklyFilms
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Query("SELECT * FROM movie_list")
    fun allMoviesFromDB(): Flow<MutableList<PopularWeeklyFilms>>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movie: PopularWeeklyFilms)

    @Delete
    suspend fun delete(movie: PopularWeeklyFilms)
}
