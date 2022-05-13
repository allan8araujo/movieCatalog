package com.example.appfilmecatalogo.data.api

import com.example.appfilmecatalogo.domain.models.Lives
import com.example.appfilmecatalogo.domain.utils.Constants
import retrofit2.http.GET

interface RetrofitService {
    @GET(Constants.PATH_URL)
    suspend fun getAllLives(): Lives
}