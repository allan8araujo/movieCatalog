package com.example.appfilmecatalogo.models

data class Live (
    var page:Long,
    var results:PopularWeeklyFilms,
    var total_pages:Long,
    var total_results:Long
)