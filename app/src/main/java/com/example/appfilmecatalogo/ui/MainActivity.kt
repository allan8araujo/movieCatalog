package com.example.appfilmecatalogo.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.appfilmecatalogo.api.RetrofitService
import com.example.appfilmecatalogo.databinding.ActivityMainBinding
import com.example.appfilmecatalogo.models.Lives
import com.example.appfilmecatalogo.models.PopularWeeklyFilms
import com.example.appfilmecatalogo.repository.Interceptor
import com.example.appfilmecatalogo.repository.MovieRepository
import com.example.appfilmecatalogo.utils.Constants
import com.example.appfilmecatalogo.viewmodel.Movie.MovieViewModel
import com.example.appfilmecatalogo.viewmodel.Movie.MovieViewModelFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private val retrofit by lazy {
        Retrofit.Builder()
             .client(httpClient)
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private val movieClient: RetrofitService by lazy {
        retrofit.create(RetrofitService::class.java)
    }

    private val httpClient by lazy {
        OkHttpClient
            .Builder()
            .addInterceptor(Interceptor())
            .build()
    }

    private val movieRepository = MovieRepository(movieClient)
    private val movieFactory = MovieViewModelFactory(movieRepository)
    private val movieViewModel by viewModels<MovieViewModel> { movieFactory }

    private val biding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val movielistAdapter = MovieItemAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(biding.root)

        movielistAdapter.onClickListener = { movieId ->
            goToMovieDetails(movieId)
        }
        biding.movieItemRecyclerView.adapter = movielistAdapter
        getMovieAndObserve()
    }

    private fun getMovieAndObserve() {
        movieViewModel.getAllLives()
        movieViewModel.movies.observe(this) { Lives ->
            setListAdapter(Lives)
        }
    }

    private fun setListAdapter(list: Lives) {
        movielistAdapter.submitList(list.results)
    }

    private fun goToMovieDetails(movieId: Int) {
        val intent = Intent(this, MovieDetailsActivity::class.java)
        val movieSelected = movieViewModel.movies.value?.results?.find { PopularWeeklyFilms ->
            PopularWeeklyFilms.id == movieId
        }

        intent.putExtra("movieId", movieId)
        intent.putExtra("movieTitle", movieSelected?.title)
        intent.putExtra("movieAdult", movieSelected?.adult)
        intent.putExtra("movieReleaseDate", movieSelected?.release_date)
        intent.putExtra("movieVoteAverage", movieSelected?.vote_average)
        intent.putExtra("movieSelected",movieSelected)
        startActivity(intent)
    }

}
