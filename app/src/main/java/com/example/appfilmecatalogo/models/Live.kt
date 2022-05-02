package com.example.appfilmecatalogo.models

data class Lives(
    val page: Long,
    val results: List<PopularWeeklyFilms>,
    val total_pages: Long,
    val total_results: Long
)