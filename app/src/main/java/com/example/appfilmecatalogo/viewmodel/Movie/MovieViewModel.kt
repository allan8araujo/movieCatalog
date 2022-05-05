package com.example.appfilmecatalogo.viewmodel.Movie

import androidx.lifecycle.*
import com.example.appfilmecatalogo.models.Lives
import com.example.appfilmecatalogo.models.movieDetails
import com.example.appfilmecatalogo.repository.IMovieRepository
import com.example.appfilmecatalogo.repository.IMovieRepositoryDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieViewModel(
    private val movieRepository: IMovieRepository
) : ViewModel() {
    private val livelist = MutableLiveData<Lives>()
    val movies: LiveData<Lives> = livelist

    fun getAllLives() {
        viewModelScope.launch {
            val movieFromApi = withContext(Dispatchers.IO) {
                movieRepository.getAllLives()
            }
            livelist.value = movieFromApi
        }
    }
}

class MovieViewModelDetails(private val movieRepositoryDetails: IMovieRepositoryDetails
) : ViewModel() {
    private val detailMovie = MutableLiveData<movieDetails>()
    val movies: LiveData<movieDetails> = detailMovie

    fun getAllLivesDetails() {
        viewModelScope.launch {
            val movieFromApiDetails = withContext(Dispatchers.IO) {
                movieRepositoryDetails.getMovieDetail()
            }
            detailMovie.value = movieFromApiDetails
        }
    }
}
