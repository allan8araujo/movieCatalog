package com.example.appfilmecatalogo.domain.utils

sealed class MovieResult<T> {
    class Loading<T> : MovieResult<T>()
    class Sucess<T>(val data: T) : MovieResult<T>()
    class Error<T>(val throwable: Throwable, val emptyLive: com.example.abstractions.models.Lives) :
        MovieResult<T>()
}
