package com.example.appfilmecatalogo.presenter.viewmodel.Movie

<<<<<<< HEAD:app/src/main/java/com/example/appfilmecatalogo/viewmodel/Movie/MovieViewModel.kt
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appfilmecatalogo.models.Lives
import com.example.appfilmecatalogo.models.MovieResult
import com.example.appfilmecatalogo.models.mockLives
import com.example.appfilmecatalogo.repository.IMovieRepository
=======
import androidx.lifecycle.*
import com.example.appfilmecatalogo.domain.models.Lives
import com.example.appfilmecatalogo.domain.models.mockLives
import com.example.appfilmecatalogo.data.repository.IMovieRepository
>>>>>>> 87ebc20bd2d2fa33cf1f870e390e1730394a467e:app/src/main/java/com/example/appfilmecatalogo/presenter/viewmodel/Movie/MovieViewModel.kt
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieViewModel(
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
