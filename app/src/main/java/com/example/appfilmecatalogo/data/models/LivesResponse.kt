package com.example.appfilmecatalogo.data.models

import com.example.appfilmecatalogo.domain.models.Lives
import com.example.appfilmecatalogo.domain.models.PopularWeeklyFilms

data class LivesResponse(
    val pageLives: Int,
    val resultsLives: MutableList<PopularWeeklyFilms>,
    val total_pagesLives: Int,
    val total_resultsLives: Int
)

fun LivesResponse.toResponse() = Lives(
    page = this.pageLives,
    results = this.resultsLives,
    total_pages = this.total_pagesLives,
    total_results = this.total_resultsLives
)