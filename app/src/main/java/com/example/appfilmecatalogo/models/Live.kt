package com.example.appfilmecatalogo.models

data class Lives(
    val page: Int,
    val results: List<PopularWeeklyFilms>,
    val total_pages: Int,
    val total_results: Int
)

fun mockLives() =
    Lives(
        1,
        listOf(
            PopularWeeklyFilms(
                true,
                "filme",
                listOf(33, 2, 1),
                3,
                "en",
                "2",
                "2",
                3f,
                "pathh_post",
                "20-02-010",
                "Homem aranha",
                true,
                32.2f,
                2,
                "3"
            ),
            PopularWeeklyFilms(
                true,
                "filme",
                listOf(33, 2, 1),
                4,
                "en",
                "2",
                "2",
                3f,
                "pathh_post",
                "20-02-010",
                "Uncharted",
                true,
                32.2f,
                2,
                "3"
            )
        ),
        1000,
        1000
    )
