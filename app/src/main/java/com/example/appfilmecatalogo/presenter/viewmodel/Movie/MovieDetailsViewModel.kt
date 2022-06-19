package com.example.appfilmecatalogo.presenter.viewmodel.Movie

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appfilmecatalogo.domain.models.PopularWeeklyFilms

class MovieDetailsViewModel : ViewModel() {
    private val mutableSelectedMovie = MutableLiveData<PopularWeeklyFilms>()
    val selectedMovie: LiveData<PopularWeeklyFilms> get() = mutableSelectedMovie

    private val mutableGlideImage = MutableLiveData<Bitmap?>()
    val selectedImage: LiveData<Bitmap?> get() = mutableGlideImage

    fun movieSelect(movie: PopularWeeklyFilms) {
        mutableSelectedMovie.value = movie
    }

    fun imageDetailSelected(image: Bitmap?) {
        mutableGlideImage.value = image
    }
}
