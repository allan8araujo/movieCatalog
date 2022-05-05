package com.example.appfilmecatalogo.api

import com.example.appfilmecatalogo.models.Lives
import com.example.appfilmecatalogo.models.movieDetails
import com.example.appfilmecatalogo.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RetrofitService {
    @GET(Constants.PATH_URL)
    suspend fun getAllLives(): Lives
}

interface RetrofitServiceDetail{
    @GET(Constants.PATH_MOVIE_DETAIL)
    suspend fun getMovieDetail():movieDetails
}

//@Query("")id:String