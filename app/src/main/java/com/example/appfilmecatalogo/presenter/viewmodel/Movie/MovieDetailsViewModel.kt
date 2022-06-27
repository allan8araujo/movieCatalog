package com.example.appfilmecatalogo.presenter.viewmodel.Movie

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.abstractions.models.PopularWeeklyFilms

class MovieDetailsViewModel : ViewModel() {

    private val mutableGlideImage = MutableLiveData<Bitmap?>()
    val selectedImage: LiveData<Bitmap?> get() = mutableGlideImage

    fun imageDetailSelected(image: Bitmap?) {
        mutableGlideImage.value = image
    }
}
