package com.example.appfilmecatalogo.presenter.viewmodel.Movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appfilmecatalogo.data.repository.IMovieRepository
import com.example.appfilmecatalogo.domain.models.Lives
import com.example.appfilmecatalogo.domain.models.mockLives
import com.example.appfilmecatalogo.domain.utils.MovieResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieListViewModel(
    private val movieRepository: IMovieRepository,
) : ViewModel() {
    private val livelist = MutableLiveData<MovieResult<Lives>>()
    val movies: LiveData<MovieResult<Lives>> = livelist

    fun getAllLives() {
        viewModelScope.launch {
            livelist.value = MovieResult.Loading()
            try {
                val movieFromApi = withContext(Dispatchers.IO) {
                    movieRepository.getAllLives()
                }
                livelist.value = MovieResult.Sucess(movieFromApi)
            } catch (e: Exception) {
                val movieResult = MovieResult.Error<Lives>(e, mockLives())
                livelist.value = movieResult
            }
        }
    }
}
