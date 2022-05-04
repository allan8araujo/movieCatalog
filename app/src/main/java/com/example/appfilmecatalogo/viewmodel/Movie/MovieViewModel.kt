package com.example.appfilmecatalogo.viewmodel.Movie

import androidx.lifecycle.*
import com.example.appfilmecatalogo.models.Lives
import com.example.appfilmecatalogo.repository.IMovieRepository
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
