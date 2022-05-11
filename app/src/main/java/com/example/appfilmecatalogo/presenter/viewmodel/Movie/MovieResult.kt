package com.example.appfilmecatalogo.presenter.viewmodel.Movie

import com.example.appfilmecatalogo.domain.models.Lives

sealed class MovieResult <T>{
    class Loading<T>: MovieResult<T>()
    class Sucess<T>(val data:T): MovieResult<T>()
    class Error<T>(val throwable: Throwable,val emptyLive: Lives): MovieResult<T>()
}