package com.example.appfilmecatalogo.models

data class PopularWeeklyFilms(
    var adult: Boolean,
    var backdrop_path: String,// "/tRS6jvPM9qPrrnx2KRp3ew96Yot.jpg",
    var genre_ids: MutableList<Int>,
    var id: Int,
    var original_language: String,
    var original_title: String,
    var overview: String,
    var popularity: Float,
    var poster_path: String,// "/74xTEgt7R36Fpooo50r9T25onhq.jpg",
    var release_date: String, //"2022-03-01",
    var title: String,
    var video: Boolean,
    var vote_average: Float,
    var vote_count: Int,
    var media_type: String
)
