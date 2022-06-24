package com.example.repository.api

import com.example.abstractions.models.Lives
import retrofit2.http.GET

interface RetrofitService {
    @GET(Constants.PATH_URL)
    suspend fun getAllLives(): Lives
}
