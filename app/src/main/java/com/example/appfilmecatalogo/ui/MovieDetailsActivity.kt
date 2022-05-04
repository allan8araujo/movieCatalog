package com.example.appfilmecatalogo.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appfilmecatalogo.databinding.ActivityDetailsMovieBinding
import com.example.appfilmecatalogo.models.PopularWeeklyFilms

class MovieDetailsActivity : AppCompatActivity() {
    private val biding by lazy {
        ActivityDetailsMovieBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(biding.root)

        val movieSelected= intent.getSerializableExtra("movieSelected") as PopularWeeklyFilms
        val movieId = intent.getIntExtra("movieId", 0)
        val movieTitle= intent.getStringExtra("movieTitle")
        val movieVoteAverage = intent.getFloatExtra("movieVoteAverage",0f)
        val movieReleaseDate = intent.getStringExtra("movieReleaseDate")
        val movieAdult= intent.getBooleanExtra("movieAdult",false)

        biding.textMovieTitleDetails.text= movieTitle
        biding.releaseDate.text= "Release date: "+movieReleaseDate
        biding.voteAverage.text= movieVoteAverage.toString()

    //tratar se for 0?
//        val movieSelected = mockLives().results.find { PopularWeeklyFilms ->
//            PopularWeeklyFilms.id == movieId
//        }


        //setData(movieSelected)
    }
    private fun setData(movieSelected:PopularWeeklyFilms?){
        movieSelected?.let {PopularWeeklyFilms ->
            biding.textMovieTitleDetails.text=PopularWeeklyFilms.title
        }
    }
}