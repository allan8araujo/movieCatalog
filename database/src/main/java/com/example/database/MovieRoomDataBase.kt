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
    abstract class MovieRoomDataBase : RoomDatabase() {
        abstract fun appDao(): MovieDao

        companion object {
            @Volatile
            private var DB_INSTANCE: MovieRoomDataBase? = null

            fun getDataBase(context: Context): MovieRoomDataBase {
                if (DB_INSTANCE == null) {
                    DB_INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        MovieRoomDataBase::class.java,
                        "cat_database"
                    )
                        .allowMainThreadQueries()
                        .build()
                }
                return DB_INSTANCE!!
            }
        }
    }
}
