package com.example.appfilmecatalogo.presenter

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.appfilmecatalogo.data.api.RetrofitInstance
import com.example.appfilmecatalogo.databinding.ActivityMainBinding
import com.example.appfilmecatalogo.presenter.util.MovieViewModelFactory
import com.example.appfilmecatalogo.presenter.viewmodel.Movie.MovieDetailsViewModel
import com.example.appfilmecatalogo.presenter.viewmodel.Movie.MovieListViewModel

class ListActivity : AppCompatActivity() {
    private val biding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(biding.root)
    }
}
