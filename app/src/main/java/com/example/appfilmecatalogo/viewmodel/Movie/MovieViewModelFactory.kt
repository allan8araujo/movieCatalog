package com.example.appfilmecatalogo.viewmodel.Movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appfilmecatalogo.repository.MovieRepository
import com.example.appfilmecatalogo.repository.MovieRepositoryDetails

class MovieViewModelFactory(private val repository: MovieRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(repository) as T
    }
}
class MovieViewModelFactoryDetails(private val repositoryDetails: MovieRepositoryDetails) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModelDetails(repositoryDetails) as T
    }
}
