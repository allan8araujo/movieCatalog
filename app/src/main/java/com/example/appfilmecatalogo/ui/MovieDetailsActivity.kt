package com.example.appfilmecatalogo.ui

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.toColor
import androidx.core.graphics.toColorLong
import com.bumptech.glide.Glide
import com.example.appfilmecatalogo.R
import com.example.appfilmecatalogo.api.HttpClient
import com.example.appfilmecatalogo.databinding.ActivityDetailsMovieBinding
import com.example.appfilmecatalogo.models.PopularWeeklyFilms
import com.example.appfilmecatalogo.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieDetailsActivity : AppCompatActivity(), View.OnClickListener {

    // private val movieRepositoryDetail = MovieRepositoryDetails(movieClientService)
    // private val movieFactoryDetails = MovieViewModelFactoryDetails(movieRepositoryDetail)
    //  private val movieViewModelDetails by viewModels<MovieViewModelDetails> { movieFactoryDetails }
    //    private val movieClientService: RetrofitServiceDetail by lazy {
    //        retrofitInstanceDetails.create(RetrofitServiceDetail::class.java)
    //    }

    private val retrofitInstanceDetails by lazy {
        Retrofit.Builder()
            .client(HttpClient.clientInterceptor)
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    private val biding by lazy {
        ActivityDetailsMovieBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(biding.root)
        supportActionBar?.hide()

        biding.movieDescription.movementMethod = ScrollingMovementMethod()
        biding.imageBack.setOnClickListener(this)
        val movieSelected = SetDataDetailsActivity()

        val overview = movieSelected.overview
        biding.movieDescription.text = overview
        Glide.with(biding.root.context)
            .load("https://image.tmdb.org/t/p/original" + movieSelected.poster_path)
            .placeholder(R.drawable.loading_details)
            .centerCrop()
            .into(biding.movieImage)
        //     movieViewModelDetails.getAllLivesDetails()
        // movieViewModel.movies.observe(this) {movieDetails -> setDetails(movieDetails)}
        //tratar se for 0?
        //setData(movieSelected)
    }

    private fun SetDataDetailsActivity(): PopularWeeklyFilms {
        val movieSelected = intent.getSerializableExtra("movieSelected") as PopularWeeklyFilms
        val movieTitle = intent.getStringExtra("movieTitle")
        val movieVoteAverage = intent.getFloatExtra("movieVoteAverage", 0f)
        val movieReleaseDate = intent.getStringExtra("movieReleaseDate")
        biding.textMovieTitleDetails.text = movieTitle
        biding.releaseDate.text = "Release date: " + movieReleaseDate
        biding.voteAverage.text = movieVoteAverage.toString()
        return movieSelected
//if (movieVoteAverage <= 5){
//    biding.voteAverage.setBackgroundColor(resources.getColor(R.color.red_avaliation))
//} else {
//    biding.voteAverage.setBackgroundColor(resources.getColor(R.color.green_avaliation))
//}
        //    val movieId = intent.getIntExtra("movieId", 0)
        //    val movieAdult = intent.getBooleanExtra("movieAdult", false)

    }

    override fun onClick(view: View) {
        if (view.id == R.id.image_back) {
            finish()
        }
    }
}