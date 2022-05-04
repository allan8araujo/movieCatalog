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

        val movieId = intent.getIntExtra("movieId", 0)
        val movieSelected= intent.getSerializableExtra("movieSelected") as PopularWeeklyFilms
        Log.i("id", movieSelected.id.toString())
        Log.i("title", movieSelected.title)
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