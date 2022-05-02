package com.example.appfilmecatalogo.repository

import com.example.appfilmecatalogo.api.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllLives() = retrofitService.getAllLives()
}