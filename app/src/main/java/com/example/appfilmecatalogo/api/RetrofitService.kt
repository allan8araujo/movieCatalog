package com.example.appfilmecatalogo.api

import com.example.appfilmecatalogo.models.Lives
import com.example.appfilmecatalogo.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Headers

interface RetrofitService {
    @GET(Constants.PATH_URL)
    suspend fun getAllLives(): Lives
}