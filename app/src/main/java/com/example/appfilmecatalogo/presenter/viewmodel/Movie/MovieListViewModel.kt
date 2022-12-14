package com.example.appfilmecatalogo.presenter.viewmodel.Movie

import androidx.lifecycle.*
import com.example.abstractions.models.Lives
import com.example.abstractions.models.PopularWeeklyFilms
import com.example.appfilmecatalogo.data.MovieRepository
import com.example.appfilmecatalogo.domain.utils.FilterTypes
import com.example.appfilmecatalogo.domain.utils.MovieResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieListViewModel(
    private val movieRepository: MovieRepository,
) : ViewModel() {
    var mutableSelectedMovie = MutableLiveData<PopularWeeklyFilms?>()
    private val livelist = MutableLiveData<MovieResult<Lives>>()
    val movies: LiveData<MovieResult<Lives>> = livelist

    init {
        getAllMovies()
    }

    val allRecordedMovies: LiveData<MutableList<PopularWeeklyFilms>>? =
        movieRepository.allMovies?.asLiveData()

    private suspend fun insertToDB(movie: PopularWeeklyFilms) {
        movieRepository.insertToDB(movie)
    }

    fun getAllMovies() {
        viewModelScope.launch {
            livelist.value = MovieResult.Loading()
            try {
                val movieFromApi = withContext(Dispatchers.IO) {
                    movieRepository.getAllLives()
                }
                livelist.value = MovieResult.Sucess(movieFromApi)
                movieFromApi.results?.forEach { popularWeeklyFilms ->
                    insertToDB(popularWeeklyFilms)
                }
            } catch (e: Exception) {
                val movieResult = MovieResult.Error<Lives>(
                    e,
                    Lives(results = allRecordedMovies?.value)
                )
                livelist.value = movieResult
            }
        }
    }

    fun setFilteredList(
        moveApiResult: MovieResult<Lives>?,
        types: FilterTypes,
    ): Lives? {
        var newlist1: Lives? = null
        if (moveApiResult is MovieResult.Sucess) {
            newlist1 = types.filterTypes(moveApiResult.data)
        } else if (moveApiResult is MovieResult.Error) {
            newlist1 = types.filterTypes(moveApiResult.data)
        }
        return newlist1
    }

    fun setMovieDetails(
        movieresult: MovieResult<Lives>?,
        movieId: Int,
    ) {
        when (movieresult) {
            is MovieResult.Loading -> {
            }
            is MovieResult.Sucess -> {
                setMovieSelected(movieresult.data, movieId)
            }
            is MovieResult.Error -> {
                setMovieSelected(Lives(results = allRecordedMovies?.value), movieId)
            }
            else -> {}
        }
    }

    private fun setMovieSelected(
        movieResult: Lives?,
        movieId: Int,
    ) {
        mutableSelectedMovie.value = movieResult?.results?.find { PopularWeeklyFilms ->
            PopularWeeklyFilms.id == movieId
        }
        mutableSelectedMovie.value?.vote_average.toString().format("%.2f")
    }
}
