package com.example.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.abstractions.models.PopularWeeklyFilms
import com.example.database.daos.MovieDao

class MovieDataBase {
    @Database(
        entities = [PopularWeeklyFilms::class],
        version = 1,
        exportSchema = false
    )
    @TypeConverters(Converters::class)
    abstract class MovieDataBase : RoomDatabase() {
        abstract fun appDao(): MovieDao

        companion object {
            @Volatile
            private var INSTANCE: MovieDataBase? = null
            fun getDataBase(context: Context): MovieDataBase {
                return INSTANCE ?: synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        MovieDataBase::class.java,
                        "cat_database"
                    ).build()
                    INSTANCE = instance
                    instance
                }
            }
        }
    }
}
