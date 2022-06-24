package com.example.appfilmecatalogo.presenter.viewmodel.Movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.repository.api.repository.IMovieRepository
import com.example.abstractions.models.Lives
import com.example.abstractions.models.mockLives
import com.example.appfilmecatalogo.domain.utils.FilterTypes
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
                val movieResult = MovieResult.Error<Lives>(e,
                    mockLives())
                livelist.value = movieResult
            }
        }
    }

    fun setFilteredList(
        moveApiResult: MovieResult<Lives>?,
        types: FilterTypes,
    ): Lives? {
        var newlist: Lives? = null
        var newlist1 = newlist
        if (moveApiResult is MovieResult.Sucess) {
            newlist1 = types.filterTypes(moveApiResult.data)
        }
        return newlist1
    }

    fun setMovieSelected(
        movieresult: MovieResult<Lives>?,
        movieId: Int,
        movieDetailViewModel: MovieDetailsViewModel
    ) {
        if (movieresult is MovieResult.Sucess) {
            val movieselected = movieresult.data.results.find { PopularWeeklyFilms ->
                PopularWeeklyFilms.id == movieId
            }
            movieselected?.let {
                movieDetailViewModel.movieSelect(movieselected)
            }
        }
    }
}
