package com.example.appfilmecatalogo.ui

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.appfilmecatalogo.api.HttpClient
import com.example.appfilmecatalogo.api.RetrofitServiceDetail
import com.example.appfilmecatalogo.databinding.ActivityDetailsMovieBinding
import com.example.appfilmecatalogo.models.PopularWeeklyFilms
import com.example.appfilmecatalogo.models.movieDetails
import com.example.appfilmecatalogo.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MovieDetailsActivity : AppCompatActivity() {

    private val retrofitInstanceDetails by lazy {
        Retrofit.Builder()
            .client(HttpClient.clientInterceptor)
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val movieClientService: RetrofitServiceDetail by lazy {
        retrofitInstanceDetails.create(RetrofitServiceDetail::class.java)
    }

    // private val movieRepositoryDetail = MovieRepositoryDetails(movieClientService)
    // private val movieFactoryDetails = MovieViewModelFactoryDetails(movieRepositoryDetail)
    //  private val movieViewModelDetails by viewModels<MovieViewModelDetails> { movieFactoryDetails }

    private val biding by lazy {
        ActivityDetailsMovieBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(biding.root)
        supportActionBar?.hide()

        biding.movieDescription.movementMethod = ScrollingMovementMethod()



        val movieSelected = intent.getSerializableExtra("movieSelected") as PopularWeeklyFilms
        val movieId = intent.getIntExtra("movieId", 0)
        val movieTitle = intent.getStringExtra("movieTitle")
        val movieVoteAverage = intent.getFloatExtra("movieVoteAverage", 0f)
        val movieReleaseDate = intent.getStringExtra("movieReleaseDate")
        val movieAdult = intent.getBooleanExtra("movieAdult", false)
        biding.textMovieTitleDetails.text = movieTitle
        biding.releaseDate.text = "Release date: " + movieReleaseDate
        biding.voteAverage.text = movieVoteAverage.toString()

        val overview = movieSelected.overview
        biding.movieDescription.text = overview

        Glide.with(biding.root.context)
            .load("https://image.tmdb.org/t/p/original" + movieSelected.poster_path)
            .centerCrop()
            //.placeholder()
            .into(biding.movieImage)

        //     movieViewModelDetails.getAllLivesDetails()
        // movieViewModel.movies.observe(this) {movieDetails -> setDetails(movieDetails)}
        //tratar se for 0?
        //setData(movieSelected)
    }

    private fun setDetails(data: movieDetails) {
//        movielistAdapter.submitList(list.results)
    }

    private fun setData(movieSelected: PopularWeeklyFilms?) {
        movieSelected?.let { PopularWeeklyFilms ->
            biding.textMovieTitleDetails.text = PopularWeeklyFilms.title
        }
    }
}