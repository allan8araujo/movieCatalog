package com.example.appfilmecatalogo.presenter.viewmodel.Movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appfilmecatalogo.domain.models.PopularWeeklyFilms

class MovieDetailsViewModel : ViewModel() {
    private val mutableSelectedMovie = MutableLiveData<PopularWeeklyFilms>()
    val selectedMovie: LiveData<PopularWeeklyFilms> get() = mutableSelectedMovie

    fun movieSelect(movie: PopularWeeklyFilms) {
        mutableSelectedMovie.value = movie
    }
}
