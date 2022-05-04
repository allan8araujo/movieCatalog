package com.example.appfilmecatalogo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appfilmecatalogo.databinding.ActivityDetailsMovieBinding
import com.example.appfilmecatalogo.databinding.ActivityMainBinding
import com.example.appfilmecatalogo.models.PopularWeeklyFilms
import com.example.appfilmecatalogo.models.mockLives

class MovieDetailsActivity : AppCompatActivity() {
    private val biding by lazy {
        ActivityDetailsMovieBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(biding.root)

        val movieId = intent.getIntExtra("movieId", 0)
        //tratar se for 0?

        val movieSelected = mockLives().results.find { PopularWeeklyFilms ->
            PopularWeeklyFilms.id == movieId
        }

        setData(movieSelected)
    }
    private fun setData(movieSelected:PopularWeeklyFilms?){
        movieSelected?.let {PopularWeeklyFilms ->
            biding.textMovieTitleDetails.text=PopularWeeklyFilms.title
        }
    }
}