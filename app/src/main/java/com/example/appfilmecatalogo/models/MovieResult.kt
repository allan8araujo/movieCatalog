package com.example.appfilmecatalogo.models

sealed class MovieResult<T> {
    class Loading<T> : MovieResult<T>()
    class Sucess<T>(val data: T) : MovieResult<T>()
    class Error<T>(val throwable: Throwable, val emptyLive: Lives) : MovieResult<T>()
}
