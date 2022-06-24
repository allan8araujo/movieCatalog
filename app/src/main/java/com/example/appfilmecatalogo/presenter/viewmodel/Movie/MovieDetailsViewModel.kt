package com.example.appfilmecatalogo.presenter.viewmodel.Movie

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.abstractions.models.PopularWeeklyFilms

class MovieDetailsViewModel : ViewModel() {
    private val mutableSelectedMovie = MutableLiveData<com.example.abstractions.models.PopularWeeklyFilms>()
    val selectedMovie: LiveData<com.example.abstractions.models.PopularWeeklyFilms> get() = mutableSelectedMovie

    private val mutableGlideImage = MutableLiveData<Bitmap?>()
    val selectedImage: LiveData<Bitmap?> get() = mutableGlideImage

    fun movieSelect(movie: com.example.abstractions.models.PopularWeeklyFilms) {
        mutableSelectedMovie.value = movie
    }

    fun imageDetailSelected(image: Bitmap?) {
        mutableGlideImage.value = image
    }
}
