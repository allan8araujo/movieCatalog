package com.example.appfilmecatalogo.presenter.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appfilmecatalogo.data.MovieRepository
import com.example.appfilmecatalogo.presenter.viewmodel.Movie.MovieListViewModel

class MovieViewModelFactory(private val repository: MovieRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieListViewModel(repository) as T
    }
}
