package com.example.appfilmecatalogo.presenter.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.appfilmecatalogo.R
import com.example.appfilmecatalogo.databinding.ActivityMainBinding
import com.example.appfilmecatalogo.presenter.viewmodel.Movie.MovieDetailsViewModel
import com.example.appfilmecatalogo.presenter.viewmodel.Movie.MovieListViewModel

class ListActivity : AppCompatActivity() {

    private val movieViewModel: MovieListViewModel by viewModels { FactoryBuilder.movieFactory }
    private val movieDetailsViewModel: MovieDetailsViewModel by viewModels()
    private val biding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val controller by lazy {
        findNavController(R.id.fragment_container)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(biding.root)
//        val transaction = supportFragmentManager.beginTransaction()
//        FragmentReplacer().movieReplaceFragment(MovieListFragment(), transaction)
    }
}
