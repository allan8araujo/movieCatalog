package com.example.appfilmecatalogo.presenter.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.appfilmecatalogo.R
import com.example.appfilmecatalogo.data.api.HttpClient
import com.example.appfilmecatalogo.data.api.RetrofitService
import com.example.appfilmecatalogo.data.repository.MovieRepository
import com.example.appfilmecatalogo.databinding.ActivityMainBinding
import com.example.appfilmecatalogo.domain.models.Lives
import com.example.appfilmecatalogo.domain.utils.Constants
import com.example.appfilmecatalogo.presenter.adapters.MovieItemAdapter
import com.example.appfilmecatalogo.presenter.viewmodel.Movie.FilterTypes
import com.example.appfilmecatalogo.presenter.viewmodel.Movie.MovieResult
import com.example.appfilmecatalogo.presenter.viewmodel.Movie.MovieViewModel
import com.example.appfilmecatalogo.presenter.viewmodel.Movie.MovieViewModelFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListActivity : AppCompatActivity(), View.OnClickListener {

    private val retrofitInstanceMain by lazy {
        Retrofit.Builder()
            .client(HttpClient.clientInterceptor)
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val movieClient: RetrofitService by lazy {
        retrofitInstanceMain.create(RetrofitService::class.java)
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
        biding.imgMenu.setOnClickListener(this)

        movielistAdapter.onClickListener = { movieId ->
            goToMovieDetails(movieId)
        }

        biding.movieItemRecyclerView.adapter = movielistAdapter
        movieViewModel.getAllLives()
        getMovieAndObserve()
    }

    private fun getMovieAndObserve() {
        movieViewModel.movies.observe(this) { movieApiResult ->
            when (movieApiResult) {
                is MovieResult.Loading -> {
                }
                is MovieResult.Sucess -> {
                    setListAdapter(movieApiResult.data)
                }
                is MovieResult.Error -> {
                    setListAdapter(movieApiResult.emptyLive)
                    (
                        Toast.makeText(
                            this,
                            "Something unexpected happened, try again later.",
                            Toast.LENGTH_LONG
                        ).show()
                        )
                }
            }
        }
    }

    private fun setListAdapter(list: Lives) {
        movielistAdapter.submitList(list.results)
    }

    private fun goToMovieDetails(movieId: Int) {
        val intent = Intent(this, MovieDetailsActivity::class.java)

        movieViewModel.movies.observe(this) { movieresult ->
            if (movieresult is MovieResult.Sucess) {
                val movieselected = movieresult.data.results.find { PopularWeeklyFilms ->
                    PopularWeeklyFilms.id == movieId
                }
                intent.putExtra("movieId", movieId)
                intent.putExtra("movieTitle", movieselected?.title)
                intent.putExtra("movieAdult", movieselected?.adult)
                intent.putExtra("movieReleaseDate", movieselected?.release_date)
                intent.putExtra("movieVoteAverage", movieselected?.vote_average)
                intent.putExtra("movieSelected", movieselected)
                startActivity(intent)
            }
        }
    }

    override fun onClick(view: View) {
        if (view.id == R.id.img_menu) {
            val popupmenu = PopupMenu(this, view)
            popupmenu.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.item1 -> {
                        movieViewModel.movies.observe(this) { moveApiResult ->
                            if (moveApiResult is MovieResult.Sucess) {
                                FilterTypes.POPULARITY.FilterTypes(moveApiResult.data)
                                movielistAdapter.notifyDataSetChanged()
                            }
                        }
                        true
                    }
                    R.id.item2 -> {
                        movieViewModel.movies.observe(this) { moveApiResult ->
                            if (moveApiResult is MovieResult.Sucess)
                                FilterTypes.RELEASE_DATE.FilterTypes(moveApiResult.data)
                            movielistAdapter.notifyDataSetChanged()
                        }
                        true
                    }
                    R.id.item3 -> {
                        movieViewModel.movies.observe(this) { moveApiResult ->
                            if (moveApiResult is MovieResult.Sucess)
                                FilterTypes.TITLE.FilterTypes(moveApiResult.data)
                            movielistAdapter.notifyDataSetChanged()
                        }
                        true
                    }
                    else -> false
                }
            }
            popupmenu.inflate(R.menu.menu_main)
            popupmenu.show()
        }
    }
}
