package com.example.appfilmecatalogo.presenter.view

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.appfilmecatalogo.R
import com.example.appfilmecatalogo.databinding.ActivityDetailsMovieBinding
import com.example.appfilmecatalogo.domain.models.PopularWeeklyFilms

class MovieDetailsActivity : AppCompatActivity(), View.OnClickListener {

    private val biding by lazy {
        ActivityDetailsMovieBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(biding.root)
        supportActionBar?.hide()
        biding.movieDescription.movementMethod = ScrollingMovementMethod()
        biding.imageBack.setOnClickListener(this)
        val movieSelected = setDataDetailsActivity()
        val overview = movieSelected.overview
        biding.movieDescription.text = overview
        Glide.with(biding.root.context)
            .load("https://image.tmdb.org/t/p/original" + movieSelected.poster_path)
            .placeholder(R.drawable.loading_details)
            .centerCrop()
            .into(biding.movieImage)
    }

    private fun setDataDetailsActivity(): PopularWeeklyFilms {
        val movieSelected = intent.getSerializableExtra("movieSelected") as PopularWeeklyFilms
        val movieTitle = intent.getStringExtra("movieTitle")
        val movieVoteAverage = intent.getFloatExtra("movieVoteAverage", 0f)
        val movieReleaseDate = intent.getStringExtra("movieReleaseDate")
        biding.textMovieTitleDetails.text = movieTitle
        biding.releaseDate.text = "Release date: $movieReleaseDate"
        biding.voteAverage.text = movieVoteAverage.toString()
        return movieSelected
    }

    override fun onClick(view: View) {
        if (view.id == R.id.image_back) {
            finish()
        }
    }
}
