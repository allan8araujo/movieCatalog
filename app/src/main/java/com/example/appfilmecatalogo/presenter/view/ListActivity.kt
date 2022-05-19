package com.example.appfilmecatalogo.presenter.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.appfilmecatalogo.databinding.ActivityMainBinding
import com.example.appfilmecatalogo.presenter.fragments.ListFragment
import com.example.appfilmecatalogo.presenter.util.FragmentReplacer
import com.example.appfilmecatalogo.presenter.viewmodel.Movie.MovieDetailsViewModel
import com.example.appfilmecatalogo.presenter.viewmodel.Movie.MovieListViewModel

class ListActivity : AppCompatActivity() {

    private val movieViewModel: MovieListViewModel by viewModels { FactoryBuilder.movieFactory }
    private val movieDetailsViewModel: MovieDetailsViewModel by viewModels()

    private val biding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(biding.root)
        val transaction = supportFragmentManager.beginTransaction()
        FragmentReplacer().movieReplaceFragment(ListFragment(), transaction)
    }
}
