package com.example.appfilmecatalogo.domain.models

import java.io.Serializable

data class PopularWeeklyFilms(
    val adult: Boolean,
    val backdrop_path: String,// "/tRS6jvPM9qPrrnx2KRp3ew96Yot.jpg",
    val genre_ids: List<Int>,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Float,
    val poster_path: String,// "/74xTEgt7R36Fpooo50r9T25onhq.jpg",
    val release_date: String, //"2022-03-01",
    val title: String,
    val video: Boolean,
    val vote_average: Float,
    val vote_count: Int,
    val media_type: String
): Serializable
