package com.example.appfilmecatalogo.domain.utils

import com.example.abstractions.models.Lives

sealed class MovieResult<T> {
    class Loading<T> : MovieResult<T>()
    class Sucess<T>(val data: T) : MovieResult<T>()
    class Error<T>(val throwable: Throwable, val data: Lives) :
        MovieResult<T>()
}
